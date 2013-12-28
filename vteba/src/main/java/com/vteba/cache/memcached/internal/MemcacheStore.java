package com.vteba.cache.memcached.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vteba.cache.memcached.Element;
import com.vteba.cache.memcached.exception.CacheException;
import com.vteba.cache.memcached.spi.Memcache;
import com.vteba.cache.memcached.spi.Store;
import com.vteba.cache.memcached.store.ElementValueComparator;

/**
 * 基于Memcache客户端实现的存储实现
 * @author yinlei
 * date 2012-11-18 下午1:30:16
 */
public class MemcacheStore implements Store {

	//private MemcacheClientDelegate client;
	private Memcache memcache;
	private static final Logger logger = LoggerFactory.getLogger(MemcacheStore.class);
	//private final List<String> keyList = new CopyOnWriteArrayList<String>();
	private final ConcurrentMap<String, String> keyMap = new ConcurrentHashMap<String, String>();
	/**
	 * 构建基于MemcacheClientDelegate的存储实例,委托给MemcachedClient
	 * @param client MemcacheClientDelegate实例
	 */
	public MemcacheStore(Memcache memcache) {
		super();
		this.memcache = memcache;
	}

	@Override
	public boolean put(Element element) throws CacheException {
		String key = element.getKey();
		if (logger.isInfoEnabled()) {
			logger.info("key={}", key);
		}
		memcache.set(key, 0, element.getObjectValue());
		//keyList.add(key);
		keyMap.put(key, key);
		return true;
	}

	@Override
	public void putAll(Collection<Element> elements) throws CacheException {
		for (Element element : elements) {
			put(element);
		}
	}

	@Override
	public Element get(String key) {
		Object object = null;
		object = memcache.get(key);
		if (object != null && !object.toString().equals("")) {
			return new Element(key, object);
		} else {
			return null;
		}
	}

	@Override
	public List<String> getKeys() {
		//return keyList;
		return new ArrayList<String>(keyMap.keySet());
	}

	@Override
	public Element remove(String key) {
		memcache.delete(key);
		//keyList.remove(key);
		keyMap.remove(key);
		return null;
	}

	@Override
	public void removeAll(Collection<String> keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	@Override
	public Element putIfAbsent(Element element) throws NullPointerException {
		Element ele = get(element.getKey());
		if (ele == null) {
			put(element);
			return null;
		}
		return ele;
	}

	@Override
	public Element removeElement(Element element, ElementValueComparator comparator) throws NullPointerException {
		if (element != null) {
			Element ele = get(element.getKey());
			if (ele != null) {
				if (comparator.equals(ele, element)) {
					remove(element.getKey());
					return ele;
				}
			}
		}
		return null;
	}

	@Override
	public boolean replace(Element old, Element element, ElementValueComparator comparator)
			throws IllegalArgumentException {
		if (old != null && element != null) {
			if (comparator.equals(old, element)) {
				put(element);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsKey(String key) {
		//Element element = get(key);
		String k = keyMap.get(key);
		if (k != null && k.equals(key)) {
			return true;
		}
		return false;
	}

	@Override
	public void expireElements() {
		//for (String key : keyList) {
		for (String key : getKeys()) {
			memcache.delete(key);
			//keyList.remove(key);
			keyMap.remove(key);
		}
		
	}

	@Override
	public Map<String, Element> getAll(Collection<String> keys) {
		Map<String, Element> map = new HashMap<String, Element>();
		for (String key : keys) {
			Element element = get(key);
			map.put(key, element);
		}
		return map;
	}

//	@Override
//	public MemcacheClientDelegate getMemcacheClientDelegate() {
//		return client;
//	}

	@Override
	public Memcache getMemcache() {
		return memcache;
	}

	@Override
	public void setMemcache(Memcache memcache) {
		this.memcache = memcache;
	}
	
	public void shutdown() {
		memcache.shutdown();
	}
}
