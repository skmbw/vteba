package com.vteba.user.action;

import java.io.IOException;
import java.io.OutputStream;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vteba.shop.shopcart.service.spi.CookieService;
import com.vteba.utils.common.RandomNumber;
import com.vteba.web.action.BaseExtAction;

/**
 * 验证码控制器。
 * @author yinlei
 * date 2013-9-3 下午6:13:12
 */
@Controller
public class AuthCodeAction extends BaseExtAction {
	private static Logger logger = LoggerFactory.getLogger(AuthCodeAction.class);
	
	@Inject
	private CookieService cookieServiceImpl;
	
	/**
	 * 获得验证码
	 * @param os ServletOutputStream
	 * @author yinlei
	 * date 2013-9-3 下午9:51:01
	 */
	@RequestMapping("/authCode")
	public void authCode(OutputStream os) {
		RandomNumber randomNumber = RandomNumber.get();
		try {
			IOUtils.copy(randomNumber.getImage(), os);
		} catch (IOException e) {
			logger.error("将验证码写入输出流错误。", e);
		}
		String authCode = randomNumber.getString().toLowerCase();
		cookieServiceImpl.addAuthCodeToCookie(authCode);
	}
}
