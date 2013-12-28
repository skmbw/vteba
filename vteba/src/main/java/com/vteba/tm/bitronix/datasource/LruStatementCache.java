package com.vteba.tm.bitronix.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Last Recently Used PreparedStatement cache with eviction listeners
 * support implementation.
 *
 *
 * @author lorban, brettw
 */
public class LruStatementCache {

    private final static Logger log = LoggerFactory.getLogger(LruStatementCache.class);

    /**
     * The <i>target</i> maxSize of the cache.  The cache may drift slightly
     * higher in size in the case that every statement in the cache is 
     * in use and therefore nothing can be evicted.  But eventually
     * (probably quickly) the cache will return to maxSize.
     */
    private int maxSize;

    /**
     * We use a LinkedHashMap with _access order_ specified in the
     * constructor.  According to the LinkedHashMap documentation:
     * <pre>
     *   A special constructor is provided to create a linked hash map
     *   whose order of iteration is the order in which its entries
     *   were last accessed, from least-recently accessed to most-recently
     *   (access-order). This kind of map is well-suited to building LRU
     *   caches. Invoking the put or get method results in an access to
     *   the corresponding entry (assuming it exists after the invocation
     *   completes).
     * </pre>
     */
    private final LinkedHashMap<JdbcPreparedStatementHandle, StatementTracker> cache;

    /**
     * A list of listeners concerned with prepared statement cache
     * evictions.
     */
    private final List<LruEvictionListener> evictionListners;

    /**
     * See the LinkedHashMap documentation.  We maintain our own size
     * here, rather than calling size(), because size() on a LinkedHashMap
     * is proportional in time (O(n)) with the size of the collection -- i.e.
     * calling size() must traverse the entire list and count the elements.
     * Tracking size ourselves provides O(1) access.
     */
    private int size;

    public LruStatementCache(int maxSize) {
        this.maxSize = maxSize;
        cache = new LinkedHashMap<JdbcPreparedStatementHandle, StatementTracker>(maxSize, 0.75f, true /* access order */);
        evictionListners = new CopyOnWriteArrayList<LruEvictionListener>();
    }

    /**
     * The provided key is just a 'shell' JdbcPreparedStatementHandle, it comes
     * in with no actual 'delegate' PreparedStatement.  However, it contains all
     * other pertinent information such as SQL statement, autogeneratedkeys
     * flag, cursor holdability, etc.  See the equals() method in the
     * JdbcPreparedStatementHandle class.  It is a complete key for a cached
     * statement.
     *
     * If there is a matching cached PreparedStatement, it will be set as the
     * delegate in the provided JdbcPreparedStatementHandle.
     *
     * @param key the cache key
     * @return the cached JdbcPreparedStatementHandle statement, or null
     */
    public JdbcPreparedStatementHandle get(JdbcPreparedStatementHandle key) {
    	synchronized (cache) {
            // See LinkedHashMap documentation.  Getting an entry means it is
	        // updated as the 'youngest' (Most Recently Used) entry.
	        StatementTracker cached = cache.get(key);
	        if (cached != null) {
	            cached.usageCount++;
	            key.setDelegate(cached.statement);
	            if (log.isDebugEnabled()) log.debug("delivered from cache with usage count " + cached.usageCount + " statement <" + key + "> in " + key.getPooledConnection());
	            return key;
	        }

	        return null;
    	}
    }

    /**
     * A statement is put into the cache.  This is called when a
     * statement is first prepared and also when a statement is
     * closed (by the client).  A "closed" statement has it's
     * usage counter decremented in the cache.
     *
     * @param key a prepared statement handle
     * @return a prepared statement
     */
    public JdbcPreparedStatementHandle put(JdbcPreparedStatementHandle key) {
    	synchronized (cache) {
            if (maxSize < 1) {
	            return null;
	        }

	        // See LinkedHashMap documentation.  Getting an entry means it is
	        // updated as the 'youngest' (Most Recently Used) entry.
	        StatementTracker cached = cache.get(key);
	        if (cached == null) {
	            if (log.isDebugEnabled()) log.debug("adding to cache statement <" + key + "> in " + key.getPooledConnection());
	            cache.put(key, new StatementTracker(key.getDelegateUnchecked()));
	            size++;
	        } else {
	            cached.usageCount--;
	            if (log.isDebugEnabled()) log.debug("returning to cache statement <" + key + "> with usage count " + cached.usageCount + " in " + key.getPooledConnection());
	        }

	        // If the size is exceeded, we will _try_ to evict one (or more)
	        // statements until the max level is again reached.  However, if
	        // every statement in the cache is 'in use', the size of the cache
	        // is not reduced.  Eventually the cache will be reduced, no worries.
	        if (size > maxSize) {
	            tryEviction();
	        }

	        return key;
    	}
    }

    /**
     * Evict all statements from the cache.  This likely happens on
     * connection close.
     */
    protected void clear() {
    	synchronized (cache) {
            Iterator<Entry<JdbcPreparedStatementHandle, LruStatementCache.StatementTracker>> it = cache.entrySet().iterator();
	        while (it.hasNext()) {
	            Map.Entry<JdbcPreparedStatementHandle, LruStatementCache.StatementTracker> entry = it.next();
	            StatementTracker tracker = (StatementTracker) entry.getValue();
	            it.remove();
	            fireEvictionEvent(tracker.statement);
	        }
	        cache.clear();
	        size = 0;
    	}
    }

    /**
     * Try to evict statements from the cache.  Only statements with a
     * current usage count of zero will be evicted.  Statements are
     * evicted until the cache is reduced to maxSize.
     */
    private void tryEviction() {
        synchronized (cache) {
            // Iteration order of the LinkedHashMap is from LRU to MRU
            Iterator<Entry<JdbcPreparedStatementHandle, LruStatementCache.StatementTracker>> it = cache.entrySet().iterator();
            while (it.hasNext()) {
            	Entry<JdbcPreparedStatementHandle, LruStatementCache.StatementTracker> entry = it.next();
                StatementTracker tracker = (StatementTracker) entry.getValue();
                if (tracker.usageCount == 0) {
                    it.remove();
                    size--;
                    JdbcPreparedStatementHandle key = (JdbcPreparedStatementHandle) entry.getKey();
                    if (log.isDebugEnabled()) log.debug("evicting from cache statement <" + key + "> " + key.getDelegateUnchecked() + " in " + key.getPooledConnection());
                    fireEvictionEvent(tracker.statement);
                    // We can stop evicting if we're at maxSize...
                    if (size <= maxSize) {
                        break;
                    }
                }
            }
        }
    }

    private void fireEvictionEvent(Object value) {
        for (LruEvictionListener listener : evictionListners) {
            listener.onEviction(value);
        }
    }

    public void addEvictionListener(LruEvictionListener listener) {
        evictionListners.add(listener);
    }

    public void removeEvictionListener(LruEvictionListener listener) {
        evictionListners.remove(listener);
    }

    private final static class StatementTracker {
        private final PreparedStatement statement;
        private int usageCount;

        private StatementTracker(PreparedStatement stmt) {
            this.statement = stmt;
            this.usageCount = 1;
        }
    }
}
