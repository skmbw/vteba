package com.vteba.cache.spring.xmemcached;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import com.vteba.cache.memcached.spi.Memcache;

/**
 * Spring security user cache, based xmemcached implementation
 * @author yinlei
 * date 2012-9-23 下午i6:27:29
 */
public class SpringSecurityUserCache implements InitializingBean, UserCache {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringSecurityUserCache.class);
	private Memcache memcache;
	
	public SpringSecurityUserCache() {
	}

	@Override
	public UserDetails getUserFromCache(String username) {
		try {
			UserDetails user = memcache.get(username);
			return user;
		} catch (Exception e) {
			logger.info("can't find user from cache, username is : {}", username);
		}
		return null;
	}

	@Override
	public void putUserInCache(UserDetails userdetails) {
		try {
			memcache.set(userdetails.getUsername(), 0, userdetails);
		} catch (Exception e) {
			logger.info("put user into cache error username is : {}", userdetails.getUsername());
		}
	}

	@Override
	public void removeUserFromCache(String username) {
		try {
			memcache.delete(username);
		} catch (Exception e) {
			logger.info("delete user form cache error,username is : {}", username);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(memcache, "cache can't be null");
	}

	public Memcache getMemcache() {
		return memcache;
	}

	public void setMemcache(Memcache memcache) {
		this.memcache = memcache;
	}
	
}
