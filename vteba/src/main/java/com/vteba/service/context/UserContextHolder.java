package com.vteba.service.context;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.shop.shopcart.service.spi.CookieService;
import com.vteba.user.model.User;

/**
 * 用户登录的相关信息持有者。
 * @author yinlei
 * date 2013-8-30 下午10:27:28
 */
@Named
public class UserContextHolder {
	
	private static CookieService cookieServiceImpl;// = SpringContextLoader.getCurrentWebApplicationContext().getBean("cookieServiceImpl", CookieService.class);
	
	public static User getCurrentUser() {
		return cookieServiceImpl.getCurrentUser();
	}
	
	public static boolean isUserLogin() {
		return cookieServiceImpl.isUserLogin();
	}

	/**
	 * @return the cookieServiceImpl
	 */
	public static CookieService getCookieServiceImpl() {
		return cookieServiceImpl;
	}

	/**
	 * @param cookieServiceImpl the CookieServiceImpl instance
	 */
	@Inject
	public static void setCookieServiceImpl(CookieService cookieServiceImpl) {
		UserContextHolder.cookieServiceImpl = cookieServiceImpl;
	}
	
}
