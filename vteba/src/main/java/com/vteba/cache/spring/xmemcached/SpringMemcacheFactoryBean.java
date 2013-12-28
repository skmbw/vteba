package com.vteba.cache.spring.xmemcached;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.Cache;

import com.vteba.cache.memcached.spi.Memcache;

/**
 * 创建spring抽象缓存SpringMemcache的工厂bean
 * @author yinlei
 * date 2012-8-23 下午3:53:50
 */
public class SpringMemcacheFactoryBean implements FactoryBean<SpringMemcache>, BeanNameAware, InitializingBean{
	private String cacheName;
	private String beanName;
	private SpringMemcache cache;
	private Memcache memcache;
	
	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public void setMemcache(Memcache memcache) {
		this.memcache = memcache;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (this.cacheName == null) {
			this.cacheName = this.beanName;
		}
		
		if (cache == null) {
			cache = new SpringMemcache(memcache);
		}
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Override
	public SpringMemcache getObject() throws Exception {
		return cache;
	}

	@Override
	public Class<? extends Cache> getObjectType() {
		return (this.cache != null ? this.cache.getClass() : Cache.class);
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
