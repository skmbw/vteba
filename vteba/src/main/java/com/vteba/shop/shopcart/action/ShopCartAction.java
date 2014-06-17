package com.vteba.shop.shopcart.action;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vteba.shop.shopcart.model.Item;
import com.vteba.shop.shopcart.service.spi.ShopCartService;
import com.vteba.util.web.ServletUtils;
import com.vteba.utils.consts.Consts;

/**
 * 购物车控制器
 * @author yinlei
 * @date 2013-8-26 下午2:06:55
 */
@Controller
@RequestMapping("/shopcart")
public class ShopCartAction {
	
	private static Logger logger = LoggerFactory.getLogger(ShopCartAction.class);
	
	@Inject
	private ShopCartService shopCartServiceImpl;
	
	/**
	 * 添加商品到购物车。
	 * @param request HttpServletRequest
	 * @return
	 */
	@RequestMapping("/addItem")
	public String addItemToCart(HttpServletRequest request) {
		Item item = new Item();
		item.setItemId(12345L);
		
		//如果用户已经登录了，则直接进行持久化的操作
		if (isUserLogin()) {
			logger.info("用户已经登录，将购物车信息直接保存。");
			
			shopCartServiceImpl.save(item);
			
		} else {//用户没有登录，将购物车信息暂存到Cookie中
			logger.info("用户没有登录，将购物车信息暂存到Cookie。");
			
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				//cookie中是否存在响应的cookie，默认不存在
				boolean exist = false;
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(Consts.VTEBA_SHOPCART_COOKIE + item.getItemId())) {
						exist = true;//cookie存在，需要更新
						ServletUtils.updateCookie(cookie, Consts.VTEBA_SHOPCART_COOKIE + item.getItemId());
					}
				}
				if (!exist) {//cookie不存在，需要新增
					ServletUtils.addCookie(Consts.VTEBA_SHOPCART_COOKIE + item.getItemId(), item.getItemId().toString());
				}
			}
		}
		
		
		return "success";
	}
	
	/**
	 * 
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return 加入购物车成功提示页
	 */
	@RequestMapping("/addItems")
	@Deprecated
	public String addItemsToCart(HttpServletRequest request, HttpServletResponse response) {
		
		return "success";
	}
	
	public boolean isUserLogin() {
		return true;
	}
	
	/**
	 * 用户登录后，保存Cookie中的购物车信息。
	 * @param request HttpServletRequest
	 * @return 保存是否成功
	 */
	public boolean saveCookieShopCart(HttpServletRequest request) {
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			List<Item> itemList = new ArrayList<Item>();
			for (Cookie cookie : cookies) {
				if (cookie.getName().startsWith(Consts.VTEBA_SHOPCART_COOKIE)) {
					Item item = new Item();
					item.setItemId(Long.valueOf(cookie.getValue()));
					itemList.add(item);
				}
			}
			shopCartServiceImpl.addItemList(itemList);
		}
		return true;
	}
	
	
}
