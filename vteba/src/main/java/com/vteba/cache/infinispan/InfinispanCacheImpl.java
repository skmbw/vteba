package com.vteba.cache.infinispan;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.infinispan.AdvancedCache;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.Configuration;
import org.infinispan.lifecycle.ComponentStatus;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.notifications.KeyFilter;
import org.infinispan.util.concurrent.NotifyingFuture;

/**
 * 对Infinispan缓存实例的封装。底层委托给org.infinispan.Cache&ltK, V&gt的实例。
 * @author yinlei
 * date 2013-6-23 下午10:59:21
 * @param <K> 缓存Key泛型类型
 * @param <V> 缓存value泛型类型
 */
@SuppressWarnings("deprecation")
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

	public void addListener(Object listener, KeyFilter filter) {
		cache.addListener(listener, filter);
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

	@Deprecated
	public NotifyingFuture<V> putAsync(K key, V value) {
		return cache.putAsync(key, value);
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
	
	public NotifyingFuture<V> putAsync(K key, V value, long lifespan,
			TimeUnit unit) {
		return cache.putAsync(key, value, lifespan, unit);
	}

	public V putIfAbsent(K key, V value) {
		return cache.putIfAbsent(key, value);
	}
	@Deprecated
	public NotifyingFuture<V> putAsync(K key, V value, long lifespan,
			TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
		return cache.putAsync(key, value, lifespan, lifespanUnit, maxIdle,
				maxIdleUnit);
	}

	public String getName() {
		return cache.getName();
	}

	public String getVersion() {
		return cache.getVersion();
	}

	public V put(K key, V value) {
		return cache.put(key, value);
	}
	@Deprecated
	public NotifyingFuture<Void> putAllAsync(Map<? extends K, ? extends V> data) {
		return cache.putAllAsync(data);
	}

	public V put(K key, V value, long lifespan, TimeUnit unit) {
		return cache.put(key, value, lifespan, unit);
	}

	public boolean remove(Object key, Object value) {
		return cache.remove(key, value);
	}
	@Deprecated
	public NotifyingFuture<Void> putAllAsync(
			Map<? extends K, ? extends V> data, long lifespan, TimeUnit unit) {
		return cache.putAllAsync(data, lifespan, unit);
	}

	public V putIfAbsent(K key, V value, long lifespan, TimeUnit unit) {
		return cache.putIfAbsent(key, value, lifespan, unit);
	}
	@Deprecated
	public NotifyingFuture<Void> putAllAsync(
			Map<? extends K, ? extends V> data, long lifespan,
			TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
		return cache.putAllAsync(data, lifespan, lifespanUnit, maxIdle,
				maxIdleUnit);
	}

	public void putAll(Map<? extends K, ? extends V> map, long lifespan,
			TimeUnit unit) {
		cache.putAll(map, lifespan, unit);
	}

	public boolean replace(K key, V oldValue, V newValue) {
		return cache.replace(key, oldValue, newValue);
	}
	@Deprecated
	public NotifyingFuture<Void> clearAsync() {
		return cache.clearAsync();
	}

	public V replace(K key, V value, long lifespan, TimeUnit unit) {
		return cache.replace(key, value, lifespan, unit);
	}
	@Deprecated
	public NotifyingFuture<V> putIfAbsentAsync(K key, V value) {
		return cache.putIfAbsentAsync(key, value);
	}

	public boolean replace(K key, V oldValue, V value, long lifespan,
			TimeUnit unit) {
		return cache.replace(key, oldValue, value, lifespan, unit);
	}
	@Deprecated
	public NotifyingFuture<V> putIfAbsentAsync(K key, V value, long lifespan,
			TimeUnit unit) {
		return cache.putIfAbsentAsync(key, value, lifespan, unit);
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
	@Deprecated
	public NotifyingFuture<V> putIfAbsentAsync(K key, V value, long lifespan,
			TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
		return cache.putIfAbsentAsync(key, value, lifespan, lifespanUnit,
				maxIdle, maxIdleUnit);
	}

	public boolean isEmpty() {
		return cache.isEmpty();
	}

	public boolean containsKey(Object key) {
		return cache.containsKey(key);
	}

	public V putIfAbsent(K key, V value, long lifespan, TimeUnit lifespanUnit,
			long maxIdleTime, TimeUnit maxIdleTimeUnit) {
		return cache.putIfAbsent(key, value, lifespan, lifespanUnit,
				maxIdleTime, maxIdleTimeUnit);
	}
	@Deprecated
	public NotifyingFuture<V> removeAsync(Object key) {
		return cache.removeAsync(key);
	}

	public boolean containsValue(Object value) {
		return cache.containsValue(value);
	}

	public void putAll(Map<? extends K, ? extends V> map, long lifespan,
			TimeUnit lifespanUnit, long maxIdleTime, TimeUnit maxIdleTimeUnit) {
		cache.putAll(map, lifespan, lifespanUnit, maxIdleTime, maxIdleTimeUnit);
	}
	@Deprecated
	public NotifyingFuture<Boolean> removeAsync(Object key, Object value) {
		return cache.removeAsync(key, value);
	}

	public void evict(K key) {
		cache.evict(key);
	}
	@Deprecated
	public NotifyingFuture<V> replaceAsync(K key, V value) {
		return cache.replaceAsync(key, value);
	}

	public V replace(K key, V value, long lifespan, TimeUnit lifespanUnit,
			long maxIdleTime, TimeUnit maxIdleTimeUnit) {
		return cache.replace(key, value, lifespan, lifespanUnit, maxIdleTime,
				maxIdleTimeUnit);
	}

	public V get(Object key) {
		return cache.get(key);
	}
	@Deprecated
	public NotifyingFuture<V> replaceAsync(K key, V value, long lifespan,
			TimeUnit unit) {
		return cache.replaceAsync(key, value, lifespan, unit);
	}

	public Configuration getCacheConfiguration() {
		return cache.getCacheConfiguration();
	}

	public EmbeddedCacheManager getCacheManager() {
		return cache.getCacheManager();
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
	@Deprecated
	public NotifyingFuture<V> replaceAsync(K key, V value, long lifespan,
			TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
		return cache.replaceAsync(key, value, lifespan, lifespanUnit, maxIdle,
				maxIdleUnit);
	}

	public Set<K> keySet() {
		return cache.keySet();
	}

	public V remove(Object key) {
		return cache.remove(key);
	}
	@Deprecated
	public NotifyingFuture<Boolean> replaceAsync(K key, V oldValue, V newValue) {
		return cache.replaceAsync(key, oldValue, newValue);
	}
	@Deprecated
	public NotifyingFuture<Boolean> replaceAsync(K key, V oldValue, V newValue,
			long lifespan, TimeUnit unit) {
		return cache.replaceAsync(key, oldValue, newValue, lifespan, unit);
	}

	public Collection<V> values() {
		return cache.values();
	}
	@Deprecated
	public NotifyingFuture<Boolean> replaceAsync(K key, V oldValue, V newValue,
			long lifespan, TimeUnit lifespanUnit, long maxIdle,
			TimeUnit maxIdleUnit) {
		return cache.replaceAsync(key, oldValue, newValue, lifespan,
				lifespanUnit, maxIdle, maxIdleUnit);
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return cache.entrySet();
	}
	@Deprecated
	public NotifyingFuture<V> getAsync(K key) {
		return cache.getAsync(key);
	}

	public void putAll(Map<? extends K, ? extends V> m) {
		cache.putAll(m);
	}

	public void clear() {
		cache.clear();
	}

	public boolean equals(Object o) {
		return cache.equals(o);
	}

	public int hashCode() {
		return cache.hashCode();
	}
	
	
}
