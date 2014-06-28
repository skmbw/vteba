package com.vteba.user.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vteba.user.model.User;
import com.vteba.web.action.BaseExtAction;

/**
 * 忘记密码控制器。
 * @author yinlei
 * @date 2013年10月3日 下午5:59:56
 */
@Controller
@RequestMapping("/user")
public class ForgetPassAction extends BaseExtAction {
	
	/**
	 * 跳转到忘记密码页面。
	 * @param request HttpServletRequest
	 * @return 忘记密码页面
	 */
	@RequestMapping("/forgetPass")
	public String forgetPass(HttpServletRequest request) {
		
		return "user/forgetPass";
	}
	
	/**
	 * 提交忘记密码信息，然后跳转到登录邮箱页面。
	 * @param user 用户信息
	 * @return 登录邮箱页面
	 */
	@RequestMapping("/doForget")
	public String doForget(User user) {
		
		
		return "user/toLoginEmail";
	}
}
