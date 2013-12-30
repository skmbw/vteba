package com.vteba.cache.spring.xmemcached;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import com.vteba.cache.memcached.spi.Memcache;
import com.vteba.util.cryption.CryptionUtils;

/**
 * Spring缓存，使用xmemcache实现，整合spring的缓存抽象
 * @author yinlei
 * date 2012-8-23 下午3:51:43
 */
public class SpringMemcache implements Cache {
	private static final Logger logger = LoggerFactory.getLogger(SpringMemcache.class);
	private Memcache cache;
	
	public SpringMemcache(Memcache cache) {
		super();
		this.cache = cache;
	}

	@Override
	public String getName() {
		return cache.getName();
	}

	@Override
	public Memcache getNativeCache() {
		return cache;
	}

	@Override
	public ValueWrapper get(Object key) {
		Object object;
		try {
			object = cache.get(CryptionUtils.toHexString(key));
			if (object != null) {
				return new SimpleValueWrapper(object);
			}
		} catch (Exception e) {
			logger.warn("Spring AbstractCache get Error. key = {}" + e.getMessage(), key, e);
		}
		return null;
	}

	@Override
	public void put(Object key, Object value) {
		try {
			String k = CryptionUtils.toHexString(key);
			cache.add(k, 0, value);
		} catch (Exception e) {
			logger.warn("Spring AbstractCache put Error. key = {}" + e.getMessage(), key, e);
		}
	}

	@Override
	public void evict(Object key) {
		try {
			String k = CryptionUtils.toHexString(key);
			cache.delete(k);
		} catch (Exception e) {
			logger.warn("Spring AbstractCache evict Error. key = {}" + e.getMessage(), key, e);
		}
	}

	@Override
	public void clear() {
		cache.flushAll();
	}

	//spring 4.0 新增
	@Override
	public <T> T get(Object key, Class<T> type) {
		String k = CryptionUtils.toHexString(key);
		return cache.get(k);
	}

}
