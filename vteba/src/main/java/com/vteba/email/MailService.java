package com.vteba.email;

import java.util.Map;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MailService {
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	
	@Inject
	private JavaMailSender mailSenderImpl;
	
	public void sendMail(Map<String, Object> maps) {
		try {
			MimeMessage mimeMessage = mailSenderImpl.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			
			helper.setFrom(maps.get("server.mail").toString());
			helper.setTo("yinlei@eecn.com.cn");
			
			mimeMessage.setSubject("这是标题呀");
			mimeMessage.setText("这是邮件的内容。", "UTF-8");
			
			mailSenderImpl.send(mimeMessage);
		} catch (Exception e) {
			logger.error("发送邮件异常。", e);
		}
	}
}
