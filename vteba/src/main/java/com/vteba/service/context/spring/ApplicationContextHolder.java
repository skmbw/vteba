package com.vteba.service.context.spring;

import javax.inject.Named;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.vteba.shop.shopcart.service.spi.CookieService;
import com.vteba.user.model.User;

/**
 * Spring ApplicationContext Holder。
 * @author yinlei 
 * date 2012-8-13 下午9:30:18
 */
@Named
public class ApplicationContextHolder implements ApplicationContextAware {

	private static ApplicationContext context;
	private static CookieService cookieServiceImpl;
	
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		ApplicationContextHolder.context = context;
	}

	/**
	 * 获取Spring ApplicationContext。
	 * @author yinlei
	 * date 2012-8-13 下午9:30:38
	 */
	public static ApplicationContext getApplicationContext() {
		return context;
	}

	public static <T> T getBean(String beanName, Class<T> requiredType) {
		return context.getBean(beanName, requiredType);
	}
	
	public static <T> T getBean(String beanName) {
		@SuppressWarnings("unchecked")
		T t = (T)context.getBean(beanName);
		return t;
	}
	
	public static <T> T getBean(Class<T> requiredType) {
		return context.getBean(requiredType);
	}
	
	//避免对静态域进行注入？
	public static User getCurrentUser() {
		if (cookieServiceImpl == null) {
			cookieServiceImpl = context.getBean("cookieServiceImpl", CookieService.class);
		}
		return cookieServiceImpl.getCurrentUser();
	}
}
