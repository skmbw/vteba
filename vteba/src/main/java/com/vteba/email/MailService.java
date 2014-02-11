package com.vteba.email;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	
	@Inject
	private JavaMailSender javaMailSender;
	
	public void sendMail(Map<String, Object> maps) {
		
	}
}
