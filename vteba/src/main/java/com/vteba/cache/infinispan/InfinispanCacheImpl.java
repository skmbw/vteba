package com.vteba.cache.infinispan;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.infinispan.AdvancedCache;
import org.infinispan.Cache;
import org.infinispan.commons.util.concurrent.NotifyingFuture;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.filter.Converter;
import org.infinispan.filter.KeyFilter;
import org.infinispan.filter.KeyValueFilter;
import org.infinispan.lifecycle.ComponentStatus;
import org.infinispan.manager.EmbeddedCacheManager;

/**
 * 对Infinispan缓存实例的封装。底层委托给org.infinispan.Cache&ltK, V&gt的实例。
 * @author yinlei
 * date 2013-6-23 下午10:59:21
 * @param <K> 缓存Key泛型类型
 * @param <V> 缓存value泛型类型
 */
public class InfinispanCacheImpl<K, V> implements InfinispanCache<K, V>{
	private Cache<K, V> cache;
	
	/**
	 * 使用org.infinispan.Cache&ltK, V&gt的实例构造封装类InfinispanCacheImpl。
	 * @param cache org.infinispan.Cache&ltK, V&gt实例
	 */
	public InfinispanCacheImpl(Cache<K, V> cache) {
		super();
		this.cache = cache;
	}

	public Cache<K, V> getNativeCache() {
		return cache;
	}

	public boolean startBatch() {
		return cache.startBatch();
	}

	public void addListener(Object listener) {
		cache.addListener(listener);
	}

	public void start() {
		cache.start();
	}

	public void stop() {
		cache.stop();
	}

	public void addListener(Object listener, KeyFilter<? super K> filter) {
		cache.addListener(listener, filter);
	}

	public void endBatch(boolean successful) {
		cache.endBatch(successful);
	}

	public void removeListener(Object listener) {
		cache.removeListener(listener);
	}

	public Set<Object> getListeners() {
		return cache.getListeners();
	}

	public <C> void addListener(Object listener,
			KeyValueFilter<? super K, ? super V> filter,
			Converter<? super K, ? super V, C> converter) {
		cache.addListener(listener, filter, converter);
	}

	public V putIfAbsent(K key, V value) {
		return cache.putIfAbsent(key, value);
	}

	public String getName() {
		return cache.getName();
	}

	public String getVersion() {
		return cache.getVersion();
	}

	public NotifyingFuture<V> putAsync(K key, V value) {
		return cache.putAsync(key, value);
	}

	public V put(K key, V value) {
		return cache.put(key, value);
	}

	public NotifyingFuture<V> putAsync(K key, V value, long lifespan,
			TimeUnit unit) {
		return cache.putAsync(key, value, lifespan, unit);
	}

	public V put(K key, V value, long lifespan, TimeUnit unit) {
		return cache.put(key, value, lifespan, unit);
	}

	public boolean remove(Object key, Object value) {
		return cache.remove(key, value);
	}

	public V putIfAbsent(K key, V value, long lifespan, TimeUnit unit) {
		return cache.putIfAbsent(key, value, lifespan, unit);
	}

	public NotifyingFuture<V> putAsync(K key, V value, long lifespan,
			TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
		return cache.putAsync(key, value, lifespan, lifespanUnit, maxIdle,
				maxIdleUnit);
	}

	public void putAll(Map<? extends K, ? extends V> map, long lifespan,
			TimeUnit unit) {
		cache.putAll(map, lifespan, unit);
	}

	public boolean replace(K key, V oldValue, V newValue) {
		return cache.replace(key, oldValue, newValue);
	}

	public NotifyingFuture<Void> putAllAsync(Map<? extends K, ? extends V> data) {
		return cache.putAllAsync(data);
	}

	public V replace(K key, V value, long lifespan, TimeUnit unit) {
		return cache.replace(key, value, lifespan, unit);
	}

	public NotifyingFuture<Void> putAllAsync(
			Map<? extends K, ? extends V> data, long lifespan, TimeUnit unit) {
		return cache.putAllAsync(data, lifespan, unit);
	}

	public boolean replace(K key, V oldValue, V value, long lifespan,
			TimeUnit unit) {
		return cache.replace(key, oldValue, value, lifespan, unit);
	}

	public NotifyingFuture<Void> putAllAsync(
			Map<? extends K, ? extends V> data, long lifespan,
			TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
		return cache.putAllAsync(data, lifespan, lifespanUnit, maxIdle,
				maxIdleUnit);
	}

	public V replace(K key, V value) {
		return cache.replace(key, value);
	}

	public V put(K key, V value, long lifespan, TimeUnit lifespanUnit,
			long maxIdleTime, TimeUnit maxIdleTimeUnit) {
		return cache.put(key, value, lifespan, lifespanUnit, maxIdleTime,
				maxIdleTimeUnit);
	}

	public void putForExternalRead(K key, V value) {
		cache.putForExternalRead(key, value);
	}

	public boolean isEmpty() {
		return cache.isEmpty();
	}

	public boolean containsKey(Object key) {
		return cache.containsKey(key);
	}

	public NotifyingFuture<Void> clearAsync() {
		return cache.clearAsync();
	}

	public V putIfAbsent(K key, V value, long lifespan, TimeUnit lifespanUnit,
			long maxIdleTime, TimeUnit maxIdleTimeUnit) {
		return cache.putIfAbsent(key, value, lifespan, lifespanUnit,
				maxIdleTime, maxIdleTimeUnit);
	}

	public NotifyingFuture<V> putIfAbsentAsync(K key, V value) {
		return cache.putIfAbsentAsync(key, value);
	}

	public NotifyingFuture<V> putIfAbsentAsync(K key, V value, long lifespan,
			TimeUnit unit) {
		return cache.putIfAbsentAsync(key, value, lifespan, unit);
	}

	public boolean containsValue(Object value) {
		return cache.containsValue(value);
	}

	public void putAll(Map<? extends K, ? extends V> map, long lifespan,
			TimeUnit lifespanUnit, long maxIdleTime, TimeUnit maxIdleTimeUnit) {
		cache.putAll(map, lifespan, lifespanUnit, maxIdleTime, maxIdleTimeUnit);
	}

	public void evict(K key) {
		cache.evict(key);
	}

	public NotifyingFuture<V> putIfAbsentAsync(K key, V value, long lifespan,
			TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
		return cache.putIfAbsentAsync(key, value, lifespan, lifespanUnit,
				maxIdle, maxIdleUnit);
	}

	public V replace(K key, V value, long lifespan, TimeUnit lifespanUnit,
			long maxIdleTime, TimeUnit maxIdleTimeUnit) {
		return cache.replace(key, value, lifespan, lifespanUnit, maxIdleTime,
				maxIdleTimeUnit);
	}

	public V get(Object key) {
		return cache.get(key);
	}

	public Configuration getCacheConfiguration() {
		return cache.getCacheConfiguration();
	}

	public EmbeddedCacheManager getCacheManager() {
		return cache.getCacheManager();
	}

	public NotifyingFuture<V> removeAsync(Object key) {
		return cache.removeAsync(key);
	}

	public AdvancedCache<K, V> getAdvancedCache() {
		return cache.getAdvancedCache();
	}

	public ComponentStatus getStatus() {
		return cache.getStatus();
	}

	public int size() {
		return cache.size();
	}

	public boolean replace(K key, V oldValue, V value, long lifespan,
			TimeUnit lifespanUnit, long maxIdleTime, TimeUnit maxIdleTimeUnit) {
		return cache.replace(key, oldValue, value, lifespan, lifespanUnit,
				maxIdleTime, maxIdleTimeUnit);
	}

	public NotifyingFuture<Boolean> removeAsync(Object key, Object value) {
		return cache.removeAsync(key, value);
	}

	public NotifyingFuture<V> replaceAsync(K key, V value) {
		return cache.replaceAsync(key, value);
	}

	public Set<K> keySet() {
		return cache.keySet();
	}

	public V remove(Object key) {
		return cache.remove(key);
	}

	public NotifyingFuture<V> replaceAsync(K key, V value, long lifespan,
			TimeUnit unit) {
		return cache.replaceAsync(key, value, lifespan, unit);
	}

	public NotifyingFuture<V> replaceAsync(K key, V value, long lifespan,
			TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
		return cache.replaceAsync(key, value, lifespan, lifespanUnit, maxIdle,
				maxIdleUnit);
	}

	public Collection<V> values() {
		return cache.values();
	}

	public NotifyingFuture<Boolean> replaceAsync(K key, V oldValue, V newValue) {
		return cache.replaceAsync(key, oldValue, newValue);
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return cache.entrySet();
	}

	public NotifyingFuture<Boolean> replaceAsync(K key, V oldValue, V newValue,
			long lifespan, TimeUnit unit) {
		return cache.replaceAsync(key, oldValue, newValue, lifespan, unit);
	}

	public NotifyingFuture<Boolean> replaceAsync(K key, V oldValue, V newValue,
			long lifespan, TimeUnit lifespanUnit, long maxIdle,
			TimeUnit maxIdleUnit) {
		return cache.replaceAsync(key, oldValue, newValue, lifespan,
				lifespanUnit, maxIdle, maxIdleUnit);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		cache.putAll(m);
	}

	public NotifyingFuture<V> getAsync(K key) {
		return cache.getAsync(key);
	}

	public void clear() {
		cache.clear();
	}


}
