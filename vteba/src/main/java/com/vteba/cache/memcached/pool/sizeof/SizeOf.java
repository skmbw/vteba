package com.vteba.cache.memcached.pool.sizeof;

import com.vteba.cache.memcached.pool.Size;
import com.vteba.cache.memcached.pool.sizeof.ObjectGraphWalker.Visitor;
import com.vteba.cache.memcached.pool.sizeof.filter.SizeOfFilter;
import com.vteba.cache.memcached.util.WeakIdentityConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract sizeOf for Java. It will rely on a proper sizeOf to measure sizes of entire object graphs
 * @author Alex Snaps
 */
public abstract class SizeOf {

    private static final Logger LOG = LoggerFactory.getLogger(SizeOf.class.getName());

    private final ObjectGraphWalker walker;

    /**
     * Builds a new SizeOf that will filter fields according to the provided filter
     * @param fieldFilter The filter to apply
     * @param caching whether to cache reflected fields
     * @see SizeOfFilter
     */
    public SizeOf(SizeOfFilter fieldFilter, boolean caching) {
        ObjectGraphWalker.Visitor visitor;
        if (caching) {
            visitor = new CachingSizeOfVisitor();
        } else {
            visitor = new SizeOfVisitor();
        }
        this.walker = new ObjectGraphWalker(visitor, fieldFilter);
    }

    /**
     * Calculates the size in memory (heap) of the instance passed in, not navigating the down graph
     *
     * @param obj the object to measure the size of
     * @return the object size in memory in bytes
     */
    public abstract long sizeOf(Object obj);

    /**
     * Measures the size in memory (heap) of the objects passed in, walking their graph down
     * Any overlap of the graphs being passed in will be recognized and only measured once
     *
     * @param maxDepth maximum depth of the object graph to traverse
     * @param abortWhenMaxDepthExceeded true if the object traversal should be aborted when the max depth is exceeded
     * @param obj the root objects of the graphs to measure
     * @return the total size in bytes for these objects
     * @see #sizeOf(Object)
     */
    public Size deepSizeOf(int maxDepth, boolean abortWhenMaxDepthExceeded, Object... obj) {
        try {
            return new Size(walker.walk(maxDepth, abortWhenMaxDepthExceeded, obj), true);
        } catch (MaxDepthExceededException e) {
            LOG.warn(e.getMessage());
            return new Size(e.getMeasuredSize(), false);
        }
    }

    /**
     * Will return the sizeOf each instance
     */
    private class SizeOfVisitor implements Visitor {

        /**
         * {@inheritDoc}
         */
        public long visit(Object object) {
            return sizeOf(object);
        }
    }

    /**
     * Will Cache already visited types
     */
    private class CachingSizeOfVisitor implements Visitor {
        private final WeakIdentityConcurrentMap<Class<?>, Long> cache = new WeakIdentityConcurrentMap<Class<?>, Long>();

        /**
         * {@inheritDoc}
         */
        public long visit(final Object object) {
            Class<?> klazz = object.getClass();
            Long cachedSize = cache.get(klazz);
            if (cachedSize == null) {
                if (klazz.isArray()) {
                    return sizeOf(object);
                } else {
                    long size = sizeOf(object);
                    cache.put(klazz, size);
                    return size;
                }
            } else {
                return cachedSize.longValue();
            }
        }
    }
}
