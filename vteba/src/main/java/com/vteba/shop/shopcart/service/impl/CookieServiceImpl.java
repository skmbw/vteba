package com.vteba.shop.shopcart.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Cookie;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.vteba.service.context.RequestContextHolder;
import com.vteba.shop.shopcart.service.spi.CookieService;
import com.vteba.user.model.User;
import com.vteba.util.cryption.DESUtils;
import com.vteba.util.web.ServletUtils;

/**
 * 基于Cookies的服务实现。
 * @author yinlei
 * @date 2013-8-26 下午1:54:00
 */
@Named
public class CookieServiceImpl implements CookieService {
	/**
	 * 验证码加密盐值
	 */
	public static final String AUTH_CODE_SALT_VALUE = "auth_code_salt_vteba_skmbw_yinlei";
	
	/**
	 * 验证码常量，明文
	 */
	public static final String VTEBA_AUTH_CODE_MN = "skmbw_vteba_auth_code_mn";
	/**
	 * 验证码常量，密文
	 */
	public static final String VTEBA_AUTH_CODE_MI = "skmbw_vteba_auth_code_mi";
	
	/**
	 * Cookie中用户ID
	 */
	public static final String VTEBA_USER_ID = "skmbw_vteba_user_id_";
	
	/**
	 * Cookie中用户名
	 */
	public static final String VTEBA_USER_NAME = "skmbw_vteba_user_name_";
	
	/**
	 * Cookie中用户账户
	 */
	public static final String VTEBA_USER_ACCOUNT = "skmbw_vteba_user_account_";
	
	/**
	 * Cookie中用户密码
	 */
	public static final String VTEBA_USER_PASS = "skmbw_vteba_user_pass_";
	
	/**
	 * Cookie中用户Email
	 */
	public static final String VTEBA_USER_EMAIL = "skmbw_vteba_user_email_";
	
	/**
	 * SHA加密算法
	 */
	@Inject
	private ShaPasswordEncoder shaPasswordEncoder;
	
	@Override
	public boolean addAuthCodeToCookie(String authCode) {
		ServletUtils.addCookie(VTEBA_AUTH_CODE_MN, authCode);
		String encodeAuthCode = shaPasswordEncoder.encodePassword(authCode, AUTH_CODE_SALT_VALUE);
		ServletUtils.addCookie(VTEBA_AUTH_CODE_MI, encodeAuthCode);
		return true;
	}
	
	@Override
	public String getAuthCodeFromCookie() {
		Cookie[] cookies = RequestContextHolder.getRequest().getCookies();
		String authCode = "";
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(VTEBA_AUTH_CODE_MI)) {
					authCode = cookie.getValue();
				}
			}
		}
		return authCode;
	}
	
	@Override
	public boolean isAuthCodeValid(String encodeAuthCode, String rawAuthCode) {
		boolean result = false;
		result = shaPasswordEncoder.isPasswordValid(encodeAuthCode, rawAuthCode, AUTH_CODE_SALT_VALUE);
		return result;
	}
	
	@Override
	public boolean isAuthCodeValid(String authCode) {
		String encodeAuthCode = getAuthCodeFromCookie();
		return isAuthCodeValid(encodeAuthCode, authCode);
	}
	
	@Override
	public void addUserToCookie(User user) {
		Map<String, String> cookieMap = new HashMap<String, String>();
		if (user != null) {
			cookieMap.put(VTEBA_USER_ID, user.getUserId().toString());
			cookieMap.put(VTEBA_USER_NAME, DESUtils.getEncryptString(user.getUserName()));
			cookieMap.put(VTEBA_USER_ACCOUNT, DESUtils.getEncryptString(user.getUserAccount()));
			cookieMap.put(VTEBA_USER_PASS, DESUtils.getEncryptString(user.getPassword()));
			cookieMap.put(VTEBA_USER_EMAIL, DESUtils.getEncryptString(user.getEmail()));
		}
		ServletUtils.addCookie(cookieMap);
	}
	
	@Override
	public User getUserFromCookie() {
		Cookie[] cookies = RequestContextHolder.getRequest().getCookies();
		User user = null;
		if (cookies != null && cookies.length > 0) {
			user = new User();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(VTEBA_USER_ID)) {
					user.setUserId(Long.valueOf(cookie.getValue()));
				} else if (cookie.getName().equals(VTEBA_USER_NAME)) {
					user.setUserName(DESUtils.getDecryptString(cookie.getValue()));
				} else if (cookie.getName().equals(VTEBA_USER_ACCOUNT )) {
					user.setUserAccount(DESUtils.getDecryptString(cookie.getValue()));
				} else if (cookie.getName().equals(VTEBA_USER_PASS)) {
					user.setPassword(DESUtils.getDecryptString(cookie.getValue()));
				} else if (cookie.getName().equals(VTEBA_USER_EMAIL)) {
					user.setEmail(DESUtils.getDecryptString(cookie.getValue()));
				}
			}
		}
		if (user.getUserId() == null || user.getUserAccount() == null) {
			user = null;
		}
		return user;
	}
	
	@Override
	public User getCurrentUser() {
		return getUserFromCookie();
	}
	
	@Override
	public boolean isUserLogin() {
		User user = getUserFromCookie();
		if (user != null && user.getUserAccount() != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean logout() {
		Cookie[] cookies = RequestContextHolder.getRequest().getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(VTEBA_USER_ID)) {
					ServletUtils.invalidCookie(cookie);
				} else if (cookie.getName().equals(VTEBA_USER_NAME)) {
					ServletUtils.invalidCookie(cookie);
				} else if (cookie.getName().equals(VTEBA_USER_ACCOUNT )) {
					ServletUtils.invalidCookie(cookie);
				} else if (cookie.getName().equals(VTEBA_USER_PASS)) {
					ServletUtils.invalidCookie(cookie);
				} else if (cookie.getName().equals(VTEBA_USER_EMAIL)) {
					ServletUtils.invalidCookie(cookie);
				}
			}
		}
		return true;
	}

}
