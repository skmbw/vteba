package com.vteba.cache.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.vteba.user.model.User;
import com.vteba.user.service.spi.UserService;
import com.vteba.utils.exception.Exceptions;

/**
 * 基于 Guava的本地缓存。
 * @author yinlei
 * date 2013-9-15 下午2:33:50
 */
@Named
public class GuavaUserCache {

	private static Logger logger = LoggerFactory.getLogger(GuavaUserCache.class);
	
	@Inject
	private UserService userServiceImpl;
	
	private LoadingCache<Long, User> cache;
	
	public GuavaUserCache() {
		
		// 设置缓存最大个数为100，缓存过期时间为5秒
		cache = CacheBuilder.newBuilder().maximumSize(100)
				.expireAfterAccess(5, TimeUnit.SECONDS)
				.build(new CacheLoader<Long, User>() {
					@Override
					public User load(Long key) throws Exception {
						logger.info("fetch from database");
						return userServiceImpl.get(key);
					}
				});
		
	}
	
	public User getUser(Long key) {
		try {
			return cache.get(key);
		} catch (ExecutionException e) {
			Exceptions.unchecked(e);
			logger.error("根据ID[{}]获取User异常。", key, e);
		}
		return null;
	}
}
