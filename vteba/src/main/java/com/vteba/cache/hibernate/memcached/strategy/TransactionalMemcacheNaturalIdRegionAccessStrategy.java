package com.vteba.cache.hibernate.memcached.strategy;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.spi.NaturalIdRegion;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.hibernate.cache.spi.access.SoftLock;
import org.hibernate.cfg.Settings;

import com.vteba.cache.hibernate.memcached.regions.MemcacheNaturalIdRegion;
import com.vteba.cache.memcached.Element;
import com.vteba.cache.memcached.spi.Store;

/**
 * JTA NaturalIdRegionAccessStrategy.
 */
public class TransactionalMemcacheNaturalIdRegionAccessStrategy
		extends AbstractMemcacheAccessStrategy<MemcacheNaturalIdRegion>
		implements NaturalIdRegionAccessStrategy {

	private final Store memcache;

	/**
	 * Construct a new collection region access strategy.
	 *
	 * @param region the Hibernate region.
	 * @param memcache the cache.
	 * @param settings the Hibernate settings.
	 */
	public TransactionalMemcacheNaturalIdRegionAccessStrategy(MemcacheNaturalIdRegion region, Store memcache, Settings settings) {
		super(region, settings);
		this.memcache = memcache;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean afterInsert(Object key, Object value ) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean afterUpdate(Object key, Object value, SoftLock lock) {
		return false;
	}


	/**
	 * {@inheritDoc}
	 */
	public Object get(Object key, long txTimestamp) throws CacheException {
		String k = keyStrategy.toKey(getRegion().getName(), 0, key);
		return memcache.get(k);
	}

	/**
	 * {@inheritDoc}
	 */
	public NaturalIdRegion getRegion() {
		return region;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean insert(Object key, Object value ) throws CacheException {
		//OptimisticCache? versioning?
		String k = keyStrategy.toKey(getRegion().getName(), 0, key);
		Element element = new Element(k, value);
		memcache.put(element);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public SoftLock lockItem(Object key, Object version) throws CacheException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean putFromLoad(Object key, Object value, long txTimestamp,
							   Object version, boolean minimalPutOverride) throws CacheException {
		String k = keyStrategy.toKey(getRegion().getName(), 0, key);
		if ( minimalPutOverride && memcache.get(k) != null ) {
			return false;
		}
		//OptimisticCache? versioning?
		Element element = new Element(k, value);
		memcache.put(element);
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove(Object key) throws CacheException {
		String k = keyStrategy.toKey(getRegion().getName(), 0, key);
		memcache.remove(k);
	}

	/**
	 * {@inheritDoc}
	 */
	public void unlockItem(Object key, SoftLock lock) throws CacheException {
		// no-op
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean update(Object key, Object value ) throws CacheException {
		String k = keyStrategy.toKey(getRegion().getName(), 0, key);
		Element element = new Element(k, value);
		return memcache.put(element);
	}

}
