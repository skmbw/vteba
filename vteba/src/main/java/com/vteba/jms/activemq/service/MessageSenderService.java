package com.vteba.jms.activemq.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.email.MailService;

@Named
public class MessageSenderService {
	@Inject
	private MailService mailService;
}
