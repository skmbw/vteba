package com.vteba.user.action;

import java.io.Serializable;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vteba.service.generic.BaseService;
import com.vteba.shop.shopcart.service.spi.CookieService;
import com.vteba.user.model.User;
import com.vteba.user.service.spi.UserService;
import com.vteba.web.action.BaseAction;

/**
 * 用户注册控制器。
 * @author yinlei
 * date 2013-8-23 下午6:45:34
 */
@Controller
@RequestMapping("/user")
public class RegisterAction extends BaseAction<User> {
	private Logger logger = LoggerFactory.getLogger(RegisterAction.class);
	
	@Inject
	private ShaPasswordEncoder shaPasswordEncoder;
	
	@Inject
	private UserService userServiceImpl;
	
	@Inject
	private CookieService cookiesServiceImpl;
	
	/**
	 * 去注册。来到注册页面。
	 * @return 注册页面
	 * @author yinlei
	 * date 2013-8-23 下午11:03:53
	 */
	@RequestMapping("/register")
	public String register() {
		return "user/register";
	}
	
	/**
	 * 用户注册逻辑，成功后跳转到用户中心/首页。
	 * @return
	 * @author yinlei
	 * date 2013-8-23 下午6:51:00
	 */
	@RequestMapping("/doRegister")
	public String doRegister(@Valid User user, BindingResult result) {
		
		logger.info("用户注册[{}]", "register");
		
		if (result.hasErrors()) {//有错误，直接返回注册页面
			return "user/register";
		}
		
		user.setUserAccount(user.getEmail());
		user.setUserName(user.getNickName());
		
		//加密密码
		String encodePass = shaPasswordEncoder.encodePassword(user.getPassword(), LoginAction.VTEBA_PASS_SALT_VALUE);
		user.setPassword(encodePass);
		
		//保存用户
		Long userId = userServiceImpl.save(user);
		
		//用户保存成功
		if (userId != null) {
			//将用户信息添加到cookie中
			cookiesServiceImpl.addUserToCookie(user);
			
		}
		
		return "index";
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<User, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
	
	
}
