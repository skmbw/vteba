package com.vteba.jms.activemq.service;

import java.util.Map;

import javax.inject.Inject;

import com.vteba.email.MailService;

//@Named
public class MailSenderService {
	@Inject
	private MailService mailService;
	
	public void sendMail(Map<String, Object> params) {
		mailService.sendMail(params);
	}
}
