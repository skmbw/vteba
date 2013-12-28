package com.vteba.util.web;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.vteba.service.context.RequestContextHolder;
import com.vteba.shop.shopcart.action.ShopCartAction;
import com.vteba.util.cryption.CryptionUtils;

/**
 * Servlet工具类
 * @author yinlei
 * date 2012-8-26 下午9:08:38
 */
public class ServletUtils {
	private static final Logger logger = LoggerFactory.getLogger(ServletUtils.class);
	
	/**
	 * 网站Cookie域
	 */
	public static final String VTEBA_DOMAIN = ".vteba.com";
	
	//Content Type 定义
	public static final String TEXT_TYPE = "text/plain";
	public static final String JSON_TYPE = "application/json";
	public static final String XML_TYPE = "text/xml";
	public static final String HTML_TYPE = "text/html";
	public static final String JS_TYPE = "text/javascript";
	public static final String EXCEL_TYPE = "application/vnd.ms-excel";

	//Header 定义
	public static final String AUTHENTICATION_HEADER = "Authorization";

	//常用数值定义
	public static final long ONE_YEAR_SECONDS = 60 * 60 * 24 * 365;

	/**
	 * 设置客户端缓存过期时间 的Header.
	 */
	public static void setExpiresHeader(HttpServletResponse response, long expiresSeconds) {
		//Http 1.0 header
		response.setDateHeader("Expires", System.currentTimeMillis() + expiresSeconds * 1000);
		//Http 1.1 header
		response.setHeader("Cache-Control", "private, max-age=" + expiresSeconds);
	}

	/**
	 * 设置禁止客户端缓存的Header.
	 */
	public static void setDisableCacheHeader(HttpServletResponse response) {
		//Http 1.0 header
		response.setDateHeader("Expires", 1L);
		response.addHeader("Pragma", "no-cache");
		//Http 1.1 header
		response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
	}

	/**
	 * 设置LastModified Header.
	 */
	public static void setLastModifiedHeader(HttpServletResponse response, long lastModifiedDate) {
		response.setDateHeader("Last-Modified", lastModifiedDate);
	}

	/**
	 * 设置Etag Header.
	 */
	public static void setEtag(HttpServletResponse response, String etag) {
		response.setHeader("ETag", etag);
	}

	/**
	 * 根据浏览器If-Modified-Since Header, 计算文件是否已被修改.<br>
	 * 
	 * 如果无修改, checkIfModify返回false ,设置304 not modify status.
	 * 
	 * @param lastModified 内容的最后修改时间.
	 */
	public static boolean checkIfModifiedSince(HttpServletRequest request, HttpServletResponse response,
			long lastModified) {
		long ifModifiedSince = request.getDateHeader("If-Modified-Since");
		if ((ifModifiedSince != -1) && (lastModified < ifModifiedSince + 1000)) {
			response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			return false;
		}
		return true;
	}

	/**
	 * 根据浏览器 If-None-Match Header, 计算Etag是否已无效.<br>
	 * 如果Etag有效, checkIfNoneMatch返回false, 设置304 not modify status.<br>
	 * 
	 * @param etag 内容的ETag.
	 */
	public static boolean checkIfNoneMatchEtag(HttpServletRequest request, HttpServletResponse response, String etag) {
		String headerValue = request.getHeader("If-None-Match");
		if (headerValue != null) {
			boolean conditionSatisfied = false;
			if (!"*".equals(headerValue)) {
				StringTokenizer commaTokenizer = new StringTokenizer(headerValue, ",");

				while (!conditionSatisfied && commaTokenizer.hasMoreTokens()) {
					String currentToken = commaTokenizer.nextToken();
					if (currentToken.trim().equals(etag)) {
						conditionSatisfied = true;
					}
				}
			} else {
				conditionSatisfied = true;
			}

			if (conditionSatisfied) {
				response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
				response.setHeader("ETag", etag);
				return false;
			}
		}
		return true;
	}

	/**
	 * 设置让浏览器弹出下载对话框的Header.
	 * 
	 * @param fileName 下载后的文件名.
	 */
	public static void setFileDownloadHeader(HttpServletResponse response, String fileName) {
		try {
			//中文文件名支持
			String encodedfileName = new String(fileName.getBytes(), "ISO8859-1");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
		} catch (UnsupportedEncodingException e) {
			logger.error("文件名[{}]编码[{}]异常", fileName, "ISO8859-1");
		}
	}

	/**
	 * 取得带相同前缀的Request Parameters.
	 * 
	 * 返回的结果的Parameter名已去除前缀.
	 */
	public static Map<String, Object> getParametersStartWith(ServletRequest request, String prefix) {
		Assert.notNull(request, "Request must not be null");
		
		Enumeration<String> paramNames = request.getParameterNames();
		Map<String, Object> params = new TreeMap<String, Object>();
		if (prefix == null) {
			prefix = "";
		}
		while (paramNames != null && paramNames.hasMoreElements()) {
			String paramName = (String) paramNames.nextElement();
			if ("".equals(prefix) || paramName.startsWith(prefix)) {
				String unprefixed = paramName.substring(prefix.length());
				String[] values = request.getParameterValues(paramName);
				if (values == null || values.length == 0) {
					// Do nothing, no values found at all.
				} else if (values.length > 1) {
					params.put(unprefixed, values);
				} else {
					params.put(unprefixed, values[0]);
				}
			}
		}
		return params;
	}

	/**
	 * 对Http Basic验证的 Header进行编码.
	 */
	public static String encodeHttpBasic(String userName, String password) {
		String encode = userName + ":" + password;
		return "Basic " + CryptionUtils.base64Encode(encode.getBytes());
	}
	
	/**
	 * 新增Cookie。
	 * @param name Cookie名
	 * @param value Cookie值
	 */
	public static void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(Integer.MAX_VALUE);//1000 * 60 * 60 * 24 * 7 * 10
		//cookie.setDomain(VTEBA_DOMAIN);
		RequestContextHolder.getResponse().addCookie(cookie);
	}

	/**
	 * 新增多组Cookie。
	 * @param cookieMap 多对Cookie Map
	 */
	public static void addCookie(Map<String, String> cookieMap) {
		for (Entry<String, String> entry : cookieMap.entrySet()) {
			addCookie(entry.getKey(), entry.getValue());
		}
	}
	
	/**
	 * 更新Cookie值。
	 * @param cookie 要被更新的Cookie
	 * @param value Cookie值
	 */
	public static void updateCookie(Cookie cookie, String value) {
		cookie.setValue(value);
		//cookie.setDomain(VTEBA_DOMAIN);
		cookie.setMaxAge(Integer.MAX_VALUE);
		RequestContextHolder.getResponse().addCookie(cookie);
	}
	
	/**
	 * 失效Cookie值。
	 * @param cookie 要被失效的cookie
	 */
	public static void invalidCookie(Cookie cookie) {
		cookie.setMaxAge(0);
		RequestContextHolder.getResponse().addCookie(cookie);
	}
	
	/**
	 * 删除所有本站Cookie信息。
	 */
	public static void removeAllCookies() {
        Cookie cookies[] = RequestContextHolder.getRequest().getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
            	if (c.getName().startsWith(ShopCartAction.VTEBA_SHOPCART_COOKIE)) {
            		c.setMaxAge(0);//设置为0，即失效
            		RequestContextHolder.getResponse().addCookie(c);
            	}
            }
        } else {
        	logger.info("没有获取到Cookie。");
        }
    }
}