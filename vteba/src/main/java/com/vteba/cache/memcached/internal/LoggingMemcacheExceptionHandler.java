package com.vteba.cache.memcached.internal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vteba.cache.memcached.spi.MemcacheExceptionHandler;

/**
 * Memcache日志异常处理器
 * @author Ray Krueger
 */
public class LoggingMemcacheExceptionHandler implements MemcacheExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(LoggingMemcacheExceptionHandler.class);

    public void handleErrorOnGet(String key, Exception e) {
        log.warn("Cache 'get' failed for key [" + key + "]", e);
    }

    public void handleErrorOnSet(String key, int cacheTimeSeconds, Object o, Exception e) {
        log.warn("Cache 'set' failed for key [" + key + "]", e);
    }

    public void handleErrorOnDelete(String key, Exception e) {
        log.warn("Cache 'delete' failed for key [" + key + "]", e);
    }

    public void handleErrorOnIncr(String key, int factor, int startingValue, Exception e) {
        log.warn("Cache 'incr' failed for key [" + key + "]", e);
    }
}
