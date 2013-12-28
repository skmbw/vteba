package com.vteba.cache.memcached.spi;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Map;

import javax.transaction.TransactionManager;

import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.GetsResponse;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.utils.Protocol;

import com.vteba.cache.memcached.Element;
import com.vteba.cache.memcached.manager.XMemcachedManager;

/**
 * 对XMemcached的接口进行简单封装。
 * @author yinlei
 * @date 2013年9月28日 下午10:14:32
 */
public interface Memcache {

	/**
	 * 根据key获取对应缓存值，timeout时间内没有返回，将抛TimeoutException。
	 * @param key 缓存键
	 * @param timeout 超时时间，单位为毫秒
	 * @return key对应的缓存值
	 */
	public <T> T get(String key, long timeout);

	/**
	 * 根据key获取对应缓存值。
	 * @param key 缓存键
	 * @return key对应的缓存值
	 */
	public <T> T get(String key);

	/**
	 * 根据key获取对应缓存值，含版本号。
	 * @param key 缓存键
	 * @return key对应的缓存值
	 */
	public <T> GetsResponse<T> gets(String key);

	/**
	 * 根据key获取对应缓存值，timeout时间内没有返回，将抛TimeoutException。
	 * @param key 缓存键
	 * @param timeout 超时时间，单位为毫秒
	 * @return key对应的缓存值封装，含版本号
	 */
	public <T> GetsResponse<T> gets(String key, long timeout);

	/**
	 * 根据key批量获取缓存值。
	 * @param keyCollections 缓存键集合
	 * @return 缓存值Map&ltkey, value&gt，key就是传入的key，value即为key对应缓存值
	 */
	public <T> Map<String, T> get(Collection<String> keyCollections);

	/**
	 * 根据key批量获取缓存值。timeout时间内没有返回，将抛TimeoutException。
	 * @param keyCollections 缓存键集合
	 * @param timeout 超时时间，单位为毫秒
	 * @return 缓存值Map&ltkey, value&gt，key就是传入的key，value即为key对应缓存值
	 */
	public <T> Map<String, T> get(Collection<String> keyCollections,
			long timeout);

	/**
	 * 根据key批量获取缓存值。返回值含版本号。
	 * @param keyCollections 缓存键集合
	 * @return 缓存值Map&ltkey, value&gt，key就是传入的key，value即为key对应缓存值封装
	 */
	public <T> Map<String, GetsResponse<T>> gets(
			Collection<String> keyCollections);

	/**
	 * 根据key批量获取缓存值，含版本号。timeout时间内没有返回，将抛TimeoutException。
	 * @param keyCollections 缓存键集合
	 * @param timeout 超时时间，单位为毫秒
	 * @return 缓存值Map&ltkey, value&gt，key就是传入的key，value即为key对应缓存值封装
	 */
	public <T> Map<String, GetsResponse<T>> gets(
			Collection<String> keyCollections, long timeout);

	/**
	 * 设置key对应的缓存值，不存在添加，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 * @return 是否成功
	 */
	public boolean set(String key, int exp, Object value);

	/**
	 * 设置key对应的缓存值，不存在添加，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 * @param timeout 操作超时时间，单位毫秒
	 * @return 是否成功
	 */
	public boolean set(String key, int exp, Object value, long timeout);

	/**
	 * 设置key对应的缓存值，不存在添加，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 */
	public void setWithNoReply(String key, int exp, Object value);

	/**
	 * 添加key对应的缓存值。key已经存在，无操作。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒，0永不过期
	 * @param value 要被缓存对象
	 * @return 是否成功
	 */
	public boolean add(String key, int exp, Object value);

	/**
	 * 添加key对应的缓存值。key已经存在，无操作。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 * @param timeout 操作超时时间，单位毫秒
	 * @return 是否成功
	 */
	public boolean add(String key, int exp, Object value, long timeout);

	/**
	 * 添加key对应的缓存值。key已经存在，无操作。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 */
	public void addWithNoReply(String key, int exp, Object value);

	/**
	 * 替换key对应的缓存值，不存在则直接返回，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 * @return 是否成功
	 */
	public boolean replace(String key, int exp, Object value);

	/**
	 * 替换key对应的缓存值，不存在则直接返回，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 * @param timeout 操作超时时间，单位毫秒
	 * @return 是否成功
	 */
	public boolean replace(String key, int exp, Object value, long timeout);

	/**
	 * 替换key对应的缓存值，不存在无操作，存在则更新。
	 * @param key 缓存键
	 * @param exp 过期时间，单位秒
	 * @param value 要被缓存对象
	 */
	public void replaceWithNoReply(String key, int exp, Object value);

	/**
	 * 将缓存值value添加到key对应的缓存值末尾，不存在则直接返回。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 * @return 是否成功
	 */
	public boolean append(String key, Object value);

	/**
	 * 将缓存值value添加到key对应的缓存值末尾，key不存在则直接返回。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 * @param timeout 操作超时时间，单位毫秒
	 * @return 是否成功
	 */
	public boolean append(String key, Object value, long timeout);

	/**
	 * 将缓存值value添加到key对应的缓存值末尾，key不存在无操作。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 */
	public void appendWithNoReply(String key, Object value);

	/**
	 * 将缓存值value添加到key对应的缓存值头部，不存在则直接返回。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 * @return 是否成功
	 */
	public boolean prepend(String key, Object value);

	/**
	 * 将缓存值value添加到key对应的缓存值头部，不存在则直接返回。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 * @param timeout 操作超时时间，单位毫秒
	 * @return 是否成功
	 */
	public boolean prepend(String key, Object value, long timeout);

	/**
	 * 将缓存值value添加到key对应的缓存值头部，不存在无操作。
	 * @param key 缓存键
	 * @param value 要被缓存对象
	 */
	public void prependWithNoReply(String key, Object value);

	/**
	 * cas设置缓存值。cas版本等于缓存中版本才更新。
	 * @param key 缓存键
	 * @param exp 过期时间 单位秒
	 * @param value 要被缓存对象
	 * @param cas 数据版本
	 * @return 是否成功
	 */
	public boolean cas(String key, int exp, Object value, long cas);

	/**
	 * cas设置缓存值。cas版本等于缓存中版本才更新。
	 * @param key 缓存键
	 * @param exp 过期时间 单位秒
	 * @param value 要被缓存对象
	 * @param timeout 操作超时，单位毫秒
	 * @param cas 数据版本
	 * @return 是否成功
	 */
	public boolean cas(String key, int exp, Object value, long timeout, long cas);

	/**
	 * 删除key缓存对象。
	 * @param key 缓存键
	 * @param timeout 操作超时，单位毫秒
	 * @return 是否成功
	 */
	public boolean delete(String key, long timeout);

	/**
	 * 删除key缓存对象。cas版本等于缓存中版本才删除。
	 * @param key 缓存键
	 * @param cas 数据版本
	 * @param timeout 操作超时，单位毫秒
	 * @return 是否成功
	 */
	public boolean delete(String key, long cas, long timeout);

	/**
	 * Set a new expiration time for an existing item。设置一个已经存在的缓存对象一个新的过期时间。
	 * @param key item's key
	 * @param exp New expiration time, in seconds. Can be up to 30 days. After 30 days, is treated as a unix timestamp of an exact date.
	 * @param opTimeout operation timeout
	 * @return true设置成功，false失败
	 */
	public boolean touch(String key, int exp, long opTimeout);

	/**
	 * Set a new expiration time for an existing item。设置一个已经存在的缓存对象一个新的过期时间。
	 * @param key item's key
	 * @param exp New expiration time, in seconds. Can be up to 30 days. After 30 days, is treated as a unix timestamp of an exact date.
	 * @return true设置成功，false失败
	 */
	public boolean touch(String key, int exp);

	/**
	 * 获取缓存对象，同事设置一个新的过期时间。
	 * @param key item's key
	 * @param newExp 以秒为单位的新的过期时间. Can be up to 30 days. After 30 days, is treated as a unix timestamp of an exact date.
	 * @param timeout 操作超时，单位毫秒
	 * @return 缓存对象
	 */
	public <T> T getAndTouch(String key, int newExp, long timeout);

	/**
	 * 获取缓存对象，同事设置一个新的过期时间。
	 * @param key item's key
	 * @param newExp 以秒为单位的新的过期时间. Can be up to 30 days. After 30 days, is treated as a unix timestamp of an exact date.
	 * @return 缓存对象
	 */
	public <T> T getAndTouch(String key, int newExp);

	/**
	 * 如果缓存的对象是一个数字字符串，递增指定值delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @return 增加后的值
	 */
	public long incr(String key, long delta);

	/**
	 * 如果缓存的对象是一个数字字符串，递增指定值delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @return 增加后的值
	 */
	public long incr(String key, long delta, long initValue);

	/**
	 * 如果缓存的对象是一个数字字符串，递增指定值delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @param timeout 操作超时 单位毫秒
	 * @return 增加后的值
	 */
	public long incr(String key, long delta, long initValue, long timeout);

	/**
	 * 如果缓存的对象是一个数字字符串，递增指定值delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @param timeout 操作超时 单位毫秒
	 * @param exp 过期时间，单位秒
	 * @return 增加后的值
	 */
	public long incr(String key, long delta, long initValue, long timeout,
			int exp);

	/**
	 * 如果缓存的对象是一个数字字符串，递增指定值delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 */
	public void incrWithNoReply(String key, long delta);

	/**
	 * 如果缓存的对象是一个数字字符串，递减delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @return 递减后的值
	 */
	public long decr(String key, long delta);

	/**
	 * 如果缓存的对象是一个数字字符串，递减delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @return 递减后的值
	 */
	public long decr(String key, long delta, long initValue);

	/**
	 * 如果缓存的对象是一个数字字符串，递减delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @param timeout 操作超时 单位毫秒
	 * @return 递减后的值
	 */
	public long decr(String key, long delta, long initValue, long timeout);

	/**
	 * 如果缓存的对象是一个数字字符串，递减delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 * @param initValue key不存在时，对象初始值
	 * @param timeout 操作超时 单位毫秒
	 * @param exp 过期时间，单位秒
	 * @return 递减后的值
	 */
	public long decr(String key, long delta, long initValue, long timeout,
			int exp);

	/**
	 * 如果缓存的对象是一个数字字符串，递减delta
	 * @param key 缓存键
	 * @param delta 要增加的值
	 */
	public void decrWithNoReply(String key, long delta);

	/**
	 * 失效所有已连接memcached server缓存数据
	 */
	public void flushAll();

	/**
	 * 失效所有已连接memcached server缓存数据。无返回，不会超时异常。
	 */
	public void flushAllWithNoReply();

	/**
	 * 失效指定memcached server上的所有缓存数据。
	 * @param address memcached server地址
	 */
	public void flushAll(InetSocketAddress address);

	/**
	 * 失效指定memcached server上的所有缓存数据。无返回，不会超时异常。
	 * @param address memcached server地址
	 */
	public void flushAllWithNoReply(InetSocketAddress address);

	/**
	 * 返回所有已连接memcached server的信息。
	 */
	public Map<InetSocketAddress, Map<String, String>> getStats();

	/**
	 * 删除指定key
	 */
	public boolean delete(String key);

	/**
	 * 删除指定key
	 */
	public void deleteWithNoReply(String key);

	/**
	 * 获得所有可用server地址
	 */
	public Collection<InetSocketAddress> getAvailableServers();

	/**
	 * 获得所使用的协议 
	 */
	public Protocol getProtocol();

	/**
	 * 获得key计数器，可用来进行incr和decr的原子操作。
	 * @param key 缓存键
	 * @return 计数器
	 */
	public Counter getCounter(String key);

	/**
	 * 获得key计数器，可用来进行incr和decr的原子操作。
	 * @param key 缓存键
	 * @param initialValue 如果key不存在，使用的初始值
	 * @return 计数器
	 */
	public Counter getCounter(String key, long initialValue);

	/**
	 * 获取server名字
	 */
	public String getName();
	
	/**
	 * 获取MemcachedClient，执行更多操作。
	 */
	public MemcachedClient getClient();
	
	/**
	 * 根据key获得缓存中的对象
	 * @param key 缓存对象key
	 * @return 缓存对象
	 * @author yinlei
	 * date 2012-11-9 下午10:53:45
	 */
	///public Object get(String key);

    public boolean contains(String key);
    
    public Map<String, Object> getMulti(String... keys);

    public void put(String key, int cacheTimeSeconds, Object obj);
    
    public void putAll(Collection<Element> elements);
    
    public boolean update(String key, Object obj);
    
    ///public void delete(String key);
    
    public void deleteAll(Collection<String> keys);
    
    public void incr(String key, int factor, int startingValue);

    public void shutdown();
    
    /**
     * 获得事务管理器
     * @author yinlei
     * date 2012-11-9 下午10:52:12
     */
    public TransactionManager getTransactionManager();
    
    /**
     * 设置事务管理器
     * @param transactionManager
     * @author yinlei
     * date 2012-11-9 下午10:52:31
     */
    public void setTransactionManager(TransactionManager transactionManager);
    
    /**
     * 获得缓存管理器
     * @author yinlei
     * date 2012-11-9 下午10:51:54
     */
    public XMemcachedManager getCacheManager();
    
    ///public String getName();
    
    public void setName(String cacheName);

	public void setMemcacheManager(XMemcachedManager memcacheManager);
	
	//public Store getStore();

}