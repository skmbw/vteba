package com.vteba.cache.spi;

/**
 * 公共缓存接口。
 * @author yinlei
 * @date 2013年10月1日 下午4:02:20
 */
public interface Cache {
	/**
     * Gets an item from the cache.
     * 从缓存中获取一个元素
     * @param key 元素key
     */
    public Object get(String key);
    
    public void shutdown();
}
