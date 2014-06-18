package com.vteba.cache.memcached.internal;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import javax.transaction.TransactionManager;

import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.Protocol;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vteba.cache.memcached.Element;
import com.vteba.cache.memcached.manager.XMemcachedManager;
import com.vteba.cache.memcached.spi.Memcache;
import com.vteba.cache.memcached.spi.MemcacheExceptionHandler;
import com.vteba.utils.exception.Exceptions;

/**
 * 对XMemcached封装的实现。
 * @author yinlei
 * @date 2013年9月28日 下午10:15:10
 */
public class MemcacheImpl implements Memcache {
	
	private static final Logger log = LoggerFactory.getLogger(MemcacheImpl.class);
	private MemcacheExceptionHandler exceptionHandler = new LoggingMemcacheExceptionHandler();
	//保留和以前的兼容，应该将其放到Store中
	//private final MemcachedClient memcachedClient;//memcache客户端,
	private TransactionManager transactionManager;//事务管理器
	private XMemcachedManager memcacheManager;//缓存管理器
	private String name;//缓存名字
	//private Store store;//底层存储
	
	//********************************//
	
	private MemcachedClient memcachedClient;

	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	public MemcacheImpl() {
		
	}
	
	/**
	 * 使用Store构造Xmemcache实例。
	 * @param store
	 */
	public MemcacheImpl(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}
	
	/**
	 * 根据key获取对应缓存值，timeout时间内没有返回，将抛TimeoutException。
	 * @param key 缓存键
	 * @param timeout 超时时间，单位为毫秒
	 * @return key对应的缓存值
	 */
	@Override
	public <T> T get(String key, long timeout) {
		try {
			return memcachedClient.get(key, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return null;
	}

	/**
	 * 根据key获取对应缓存值。
	 * @param key 缓存键
	 * @return key对应的缓存值
	 */
	@Override
	public <T> T get(String key) {
		try {
			return memcachedClient.get(key);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return null;
	}

	/**
	 * 根据key获取对应缓存值，含版本号。
	 * @param key 缓存键
	 * @return key对应的缓存值
	 */
	@Override
	public <T> GetsResponse<T> gets(String key) {
		try {
			return memcachedClient.gets(key);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return null;
	}

	/**
	 * 根据key获取对应缓存值，timeout时间内没有返回，将抛TimeoutException。
	 * @param key 缓存键
	 * @param timeout 超时时间，单位为毫秒
	 * @return key对应的缓存值封装，含版本号
	 */
	@Override
	public <T> GetsResponse<T> gets(String key, long timeout) {
		try {
			return memcachedClient.gets(key, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return null;
		}
	}

	/**
	 * 根据key批量获取缓存值。
	 * @param keyCollections 缓存键集合
	 * @return 缓存值Map&ltkey, value&gt，key就是传入的key，value即为key对应缓存值
	 */
	@Override
	public <T> Map<String, T> get(Collection<String> keyCollections) {
		try {
			return memcachedClient.get(keyCollections);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return null;
		}
	}

	/**
	 * 根据key批量获取缓存值。timeout时间内没有返回，将抛TimeoutException。
	 * @param keyCollections 缓存键集合
	 * @param timeout 超时时间，单位为毫秒
	 * @return 缓存值Map&ltkey, value&gt，key就是传入的key，value即为key对应缓存值
	 */
	@Override
	public <T> Map<String, T> get(Collection<String> keyCollections, long timeout) {
		try {
			return memcachedClient.get(keyCollections, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return null;
		}
	}

	/**
	 * 根据key批量获取缓存值。返回值含版本号。
	 * @param keyCollections 缓存键集合
	 * @return 缓存值Map&ltkey, value&gt，key就是传入的key，value即为key对应缓存值封装
	 */
	@Override
	public <T> Map<String, GetsResponse<T>> gets(Collection<String> keyCollections) {
		try {
			return memcachedClient.gets(keyCollections);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return null;
		}
	}

	/**
	 * 根据key批量获取缓存值，含版本号。timeout时间内没有返回，将抛TimeoutException。
	 * @param keyCollections 缓存键集合
	 * @param timeout 超时时间，单位为毫秒
	 * @return 缓存值Map&ltkey, value&gt，key就是传入的key，value即为key对应缓存值封装
	 */
	@Override
	public <T> Map<String, GetsResponse<T>> gets(Collection<String> keyCollections, long timeout) {
		try {
			return memcachedClient.gets(keyCollections, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return null;
		}
	}

	/**
	 * 设置key对应的缓存值，不存在添加，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 * @return 是否成功
	 */
	@Override
	public boolean set(String key, int exp, Object value) {
		try {
			return memcachedClient.set(key, exp, value);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return false;
		}
	}

	/**
	 * 设置key对应的缓存值，不存在添加，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 * @param timeout 操作超时时间，单位毫秒
	 * @return 是否成功
	 */
	@Override
	public boolean set(String key, int exp, Object value, long timeout) {
		try {
			return memcachedClient.set(key, exp, value, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return false;
	}

	/**
	 * 设置key对应的缓存值，不存在添加，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 */
	@Override
	public void setWithNoReply(String key, int exp, Object value) {
		try {
			memcachedClient.setWithNoReply(key, exp, value);
		} catch (InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
	}

	/**
	 * 添加key对应的缓存值。key已经存在，无操作。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒，0永不过期
	 * @param value 要被缓存对象
	 * @return 是否成功
	 */
	@Override
	public boolean add(String key, int exp, Object value) {
		try {
			return memcachedClient.add(key, exp, value);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return false;
		}
	}

	/**
	 * 添加key对应的缓存值。key已经存在，无操作。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 * @param timeout 操作超时时间，单位毫秒
	 * @return 是否成功
	 */
	@Override
	public boolean add(String key, int exp, Object value, long timeout) {
		try {
			return memcachedClient.add(key, exp, value, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return false;
	}

	/**
	 * 添加key对应的缓存值。key已经存在，无操作。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 */
	@Override
	public void addWithNoReply(String key, int exp, Object value) {
		try {
			memcachedClient.addWithNoReply(key, exp, value);
		} catch (InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
	}

	/**
	 * 替换key对应的缓存值，不存在则直接返回，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 * @return 是否成功
	 */
	@Override
	public boolean replace(String key, int exp, Object value) {
		try {
			return memcachedClient.replace(key, exp, value);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return false;
		}
	}

	/**
	 * 替换key对应的缓存值，不存在则直接返回，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 * @param timeout 操作超时时间，单位毫秒
	 * @return 是否成功
	 */
	@Override
	public boolean replace(String key, int exp, Object value, long timeout) {
		try {
			return memcachedClient.replace(key, exp, value, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return false;
	}

	/**
	 * 替换key对应的缓存值，不存在无操作，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 */
	@Override
	public void replaceWithNoReply(String key, int exp, Object value) {
		try {
			memcachedClient.replaceWithNoReply(key, exp, value);
		} catch (InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
	}

	/**
	 * 将缓存值value添加到key对应的缓存值末尾，不存在则直接返回。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 * @return 是否成功
	 */
	@Override
	public boolean append(String key, Object value) {
		try {
			return memcachedClient.append(key, value);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return false;
	}

	/**
	 * 将缓存值value添加到key对应的缓存值末尾，key不存在则直接返回。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 * @param timeout 操作超时时间，单位毫秒
	 * @return 是否成功
	 */
	@Override
	public boolean append(String key, Object value, long timeout) {
		try {
			return memcachedClient.append(key, value, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return false;
	}

	/**
	 * 将缓存值value添加到key对应的缓存值末尾，key不存在无操作。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 */
	@Override
	public void appendWithNoReply(String key, Object value) {
		try {
			memcachedClient.appendWithNoReply(key, value);
		} catch (InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
	}

	/**
	 * 将缓存值value添加到key对应的缓存值头部，不存在则直接返回。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 * @return 是否成功
	 */
	@Override
	public boolean prepend(String key, Object value) {
		try {
			return memcachedClient.prepend(key, value);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return false;
		}
	}

	/**
	 * 将缓存值value添加到key对应的缓存值头部，不存在则直接返回。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 * @param timeout 操作超时时间，单位毫秒
	 * @return 是否成功
	 */
	@Override
	public boolean prepend(String key, Object value, long timeout) {
		try {
			return memcachedClient.prepend(key, value, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return false;
		}
	}

	/**
	 * 将缓存值value添加到key对应的缓存值头部，不存在无操作。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 */
	@Override
	public void prependWithNoReply(String key, Object value) {
		try {
			memcachedClient.prependWithNoReply(key, value);
		} catch (InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
	}

	/**
	 * cas设置缓存值。cas版本等于缓存中版本才更新。
	 * @param key 缓存键
	 * @param exp 过期时间 单位秒
	 * @param value 要被缓存对象
	 * @param cas 数据版本
	 * @return 是否成功
	 */
	@Override
	public boolean cas(String key, int exp, Object value, long cas) {
		try {
			return memcachedClient.cas(key, exp, value, cas);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return false;
	}

	/**
	 * cas设置缓存值。cas版本等于缓存中版本才更新。
	 * @param key 缓存键
	 * @param exp 过期时间 单位秒
	 * @param value 要被缓存对象
	 * @param timeout 操作超时，单位毫秒
	 * @param cas 数据版本
	 * @return 是否成功
	 */
	@Override
	public boolean cas(String key, int exp, Object value, long timeout, long cas) {
		try {
			return memcachedClient.cas(key, exp, value, timeout, cas);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return false;
		}
	}

	/**
	 * 删除key缓存对象。
	 * @param key 缓存键
	 * @param timeout 操作超时，单位毫秒
	 * @return 是否成功
	 */
	@Override
	public boolean delete(String key, long timeout) {
		try {
			return memcachedClient.delete(key, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return false;
		}
	}

	/**
	 * 删除key缓存对象。cas版本等于缓存中版本才删除。
	 * @param key 缓存键
	 * @param cas 数据版本
	 * @param timeout 操作超时，单位毫秒
	 * @return 是否成功
	 */
	@Override
	public boolean delete(String key, long cas, long timeout) {
		try {
			return memcachedClient.delete(key, cas, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return false;
		}
	}

	/**
	 * Set a new expiration time for an existing item。设置一个已经存在的缓存对象一个新的过期时间。
	 * @param key item's key
	 * @param exp New expiration time, in seconds. Can be up to 30 days. After 30 days, is treated as a unix timestamp of an exact date.
	 * @param opTimeout operation timeout
	 * @return true设置成功，false失败
	 */
	@Override
	public boolean touch(String key, int exp, long opTimeout) {
		try {
			return memcachedClient.touch(key, exp, opTimeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return false;
	}

	/**
	 * Set a new expiration time for an existing item。设置一个已经存在的缓存对象一个新的过期时间。
	 * @param key item's key
	 * @param exp New expiration time, in seconds. Can be up to 30 days. After 30 days, is treated as a unix timestamp of an exact date.
	 * @return true设置成功，false失败
	 */
	@Override
	public boolean touch(String key, int exp) {
		try {
			return memcachedClient.touch(key, exp);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return false;
	}

	/**
	 * 获取缓存对象，同事设置一个新的过期时间。
	 * @param key item's key
	 * @param newExp 以秒为单位的新的过期时间. Can be up to 30 days. After 30 days, is treated as a unix timestamp of an exact date.
	 * @param timeout 操作超时，单位毫秒
	 * @return 缓存对象
	 */
	@Override
	public <T> T getAndTouch(String key, int newExp, long timeout) {
		try {
			return memcachedClient.getAndTouch(key, newExp, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return null;
		}
	}

	/**
	 * 获取缓存对象，同事设置一个新的过期时间。
	 * @param key item's key
	 * @param newExp 以秒为单位的新的过期时间. Can be up to 30 days. After 30 days, is treated as a unix timestamp of an exact date.
	 * @return 缓存对象
	 */
	@Override
	public <T> T getAndTouch(String key, int newExp) {
		try {
			return memcachedClient.getAndTouch(key, newExp);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return null;
		}
	}

	/**
	 * 如果缓存的对象是一个数字字符串，递增指定值delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @return 增加后的值
	 */
	@Override
	public long incr(String key, long delta) {
		try {
			return memcachedClient.incr(key, delta);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return -1;
		}
	}

	/**
	 * 如果缓存的对象是一个数字字符串，递增指定值delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @return 增加后的值
	 */
	@Override
	public long incr(String key, long delta, long initValue) {
		try {
			return memcachedClient.incr(key, delta, initValue);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return -1;
		}
	}

	/**
	 * 如果缓存的对象是一个数字字符串，递增指定值delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @param timeout 操作超时 单位毫秒
	 * @return 增加后的值
	 */
	@Override
	public long incr(String key, long delta, long initValue, long timeout) {
		try {
			return memcachedClient.incr(key, delta, initValue, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return -1;
		}
	}

	/**
	 * 如果缓存的对象是一个数字字符串，递增指定值delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @param timeout 操作超时 单位毫秒
	 * @param exp 过期时间，单位秒
	 * @return 增加后的值
	 */
	@Override
	public long incr(String key, long delta, long initValue, long timeout, int exp) {
		try {
			return memcachedClient.incr(key, delta, initValue, timeout, exp);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return -1;
		}
	}
	
	/**
	 * 如果缓存的对象是一个数字字符串，递增指定值delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 */
	@Override
	public void incrWithNoReply(String key, long delta) {
		try {
			memcachedClient.incrWithNoReply(key, delta);
		} catch (InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
	}
	
	/**
	 * 如果缓存的对象是一个数字字符串，递减delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @return 递减后的值
	 */
	@Override
	public long decr(String key, long delta) {
		try {
			return memcachedClient.decr(key, delta);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return -1;
		}
	}

	/**
	 * 如果缓存的对象是一个数字字符串，递减delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @return 递减后的值
	 */
	@Override
	public long decr(String key, long delta, long initValue) {
		try {
			return memcachedClient.decr(key, delta, initValue);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return -1;
		}
	}

	/**
	 * 如果缓存的对象是一个数字字符串，递减delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @param timeout 操作超时 单位毫秒
	 * @return 递减后的值
	 */
	@Override
	public long decr(String key, long delta, long initValue, long timeout) {
		try {
			return memcachedClient.decr(key, delta, initValue, timeout);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return -1;
		}
	}

	/**
	 * 如果缓存的对象是一个数字字符串，递减delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @param timeout 操作超时 单位毫秒
	 * @param exp 过期时间，单位秒
	 * @return 递减后的值
	 */
	@Override
	public long decr(String key, long delta, long initValue, long timeout, int exp) {
		try {
			return memcachedClient.decr(key, delta, initValue, timeout, exp);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
			return -1;
		}
	}

	/**
	 * 如果缓存的对象是一个数字字符串，递减delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 */
	@Override
	public void decrWithNoReply(String key, long delta) {
		try {
			memcachedClient.decrWithNoReply(key, delta);
		} catch (InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
	}
	
	/**
	 * 失效所有已连接memcached server缓存数据
	 */
	@Override
	public void flushAll() {
		try {
			memcachedClient.flushAll();
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
	}

	/**
	 * 失效所有已连接memcached server缓存数据。无返回，不会超时异常。
	 */
	@Override
	public void flushAllWithNoReply() {
		try {
			memcachedClient.flushAllWithNoReply();
		} catch (InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
	}

	/**
	 * 失效指定memcached server上的所有缓存数据。
	 * @param address memcached server地址
	 */
	@Override
	public void flushAll(InetSocketAddress address) {
		try {
			memcachedClient.flushAll(address);
		} catch (MemcachedException | InterruptedException | TimeoutException e) {
			Exceptions.memcacheException(e);
		}
	}

	/**
	 * 失效指定memcached server上的所有缓存数据。无返回，不会超时异常。
	 * @param address memcached server地址
	 */
	@Override
	public void flushAllWithNoReply(InetSocketAddress address) {
		try {
			memcachedClient.flushAllWithNoReply(address);
		} catch (MemcachedException | InterruptedException e) {
			Exceptions.memcacheException(e);
		}
	}

	/**
	 * 返回所有已连接memcached server的信息。
	 */
	@Override
	public Map<InetSocketAddress, Map<String, String>> getStats() {
		try {
			return memcachedClient.getStats();
		} catch (MemcachedException | InterruptedException | TimeoutException e) {
			Exceptions.memcacheException(e);
		}
		return Collections.emptyMap();
	}

	/**
	 * 删除指定key
	 */
	@Override
	public boolean delete(String key) {
		try {
			return memcachedClient.delete(key);
		} catch (TimeoutException | InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
		return false;
	}

	/**
	 * 删除指定key
	 */
	@Override
	public void deleteWithNoReply(String key) {
		try {
			memcachedClient.deleteWithNoReply(key);
		} catch (InterruptedException | MemcachedException e) {
			Exceptions.memcacheException(e);
		}
	}
	
	/**
	 * 获得所有可用server地址
	 */
	@Override
	public Collection<InetSocketAddress> getAvailableServers() {
		return memcachedClient.getAvailableServers();
	}

	/**
	 * 获得所使用的协议 
	 */
	@Override
	public Protocol getProtocol() {
		return memcachedClient.getProtocol();
	}

	/**
	 * 获得key计数器，可用来进行incr和decr的原子操作。
	 * @param key 缓存键
	 * @return 计数器
	 */
	@Override
	public Counter getCounter(String key) {
		return memcachedClient.getCounter(key);
	}

	/**
	 * 获得key计数器，可用来进行incr和decr的原子操作。
	 * @param key 缓存键
	 * @param initialValue 如果key不存在，使用的初始值
	 * @return 计数器
	 */
	@Override
	public Counter getCounter(String key, long initialValue) {
		return memcachedClient.getCounter(key, initialValue);
	}

	/**
	 * 获取server名字
	 */
	@Override
	public String getName() {
		if (this.name != null) {
			return this.name;
		} else {
			return memcachedClient.getName();
		}
	}
	
	/**
	 * 获取MemcachedClient，执行更多操作。
	 */
	public MemcachedClient getClient() {
		return memcachedClient;
	}

	
	//****************************************************//
	
//	public Object get(String key) {
//		try {
//			log.debug("MemcachedClient.get({})", key);
//			//Object object = this.memcachedClient.get(key);
//			Object object = getInternal(key);
//			if (object != null && object.toString().equals("")) {
//				return null;
//			} else {
//				return object;
//			}
//		} catch (Exception e) {
//			this.exceptionHandler.handleErrorOnGet(key, e);
//		}
//		return null;
//	}
	
//	public Object getInternal(String key) {
//		Element obj = store.get(key);
//		if (obj != null) {
//			return obj.getObjectValue();
//		} else {
//			return null;
//		}
//	}
	
	public Map<String, Object> getMulti(String... keys) {
		try {
			return this.memcachedClient.get(Arrays.asList(keys));
			//return getMultiInternal(keys);
		} catch (Exception e) {
			this.exceptionHandler.handleErrorOnGet(StringUtils.join(keys, ", "), e);
		}
		return null;
	}
	
//	public Map<String, Object> getMultiInternal(String... keys){
//		store.getAll(Arrays.asList(keys));
//		Map<String, Object> maps = new HashMap<String, Object>();
//		
//		return maps;
//	}
	
	public void put(String key, int cacheTimeSeconds, Object obj) {
		log.debug("MemcachedClient.set({})", key);
		try {
			this.memcachedClient.set(key, cacheTimeSeconds, obj);
			//putInternal(key, cacheTimeSeconds, obj);
		} catch (Exception e) {
			this.exceptionHandler.handleErrorOnSet(key, cacheTimeSeconds, obj, e);
		}
	}
	
//	public void putInternal(String key, int cacheTimeSeconds, Object obj){
//		Element element = new Element(key, obj, cacheTimeSeconds);
//		store.put(element);
//	}
	
//	public void delete(String key) {
//		try {
//			//this.memcachedClient.delete(key);
//			deleteInternal(key);
//		} catch (Exception e) {
//			this.exceptionHandler.handleErrorOnDelete(key, e);
//		}
//	}

//	public void deleteInternal(String key) {
//		store.remove(key);
//	}
	
	public void incr(String key, int factor, int initValue) {
		try {
			this.memcachedClient.incr(key, factor, initValue);
			//this.store.getMemcache().incr(key, factor, startingValue);
		} catch (Exception e) {
			this.exceptionHandler.handleErrorOnIncr(key, factor, initValue, e);
		}
	}

	public void shutdown() {
		log.debug("Shutting down XMemcachedClient");
		try {
			this.memcachedClient.shutdown();
		} catch (Exception e) {
			log.error("Shut down XMemcachedClient error", e);
		}

	}

	public void setExceptionHandler(MemcacheExceptionHandler exceptionHandler) {
		this.exceptionHandler = exceptionHandler;
	}
	
	@Override
	public void setTransactionManager(TransactionManager transactionManager) {
		this.transactionManager = transactionManager;
		
	}
	
	@Override
	public TransactionManager getTransactionManager() {
		return transactionManager;
	}

	@Override
	public XMemcachedManager getCacheManager() {
		return memcacheManager;
	}

	@Override
	public void setMemcacheManager(XMemcachedManager memcacheManager) {
		this.memcacheManager = memcacheManager;
	}

	///@Override
	///public String getName() {
	///	return name;
	///}

	@Override
	public void setName(String name) {
		this.name = name;
	}

//	@Override
//	public void setStore(Store store) {
//		this.store = store;
//	}
//
//	@Override
//	public Store getStore() {
//		return store;
//	}

	@Override
	public boolean contains(String key) {
		//return store.containsKey(key);
		return false;
	}

	@Override
	public void putAll(Collection<Element> elements) {
		//store.putAll(elements);
	}

	@Override
	public boolean update(String key, Object obj) {
		return false;
	}

	@Override
	public void deleteAll(Collection<String> keys) {
		//store.removeAll(keys);
	}
}
