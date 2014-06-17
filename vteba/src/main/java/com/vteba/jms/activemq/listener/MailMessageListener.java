package com.vteba.jms.activemq.listener;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vteba.jms.activemq.service.MailSenderService;

//@Named
public class MailMessageListener implements MessageListener {
	private static final Logger logger = LoggerFactory.getLogger(MailMessageListener.class);
	
	@Inject
	private MailSenderService mailSenderService;
	
	@Override
	public void onMessage(Message message) {
		try {
			MapMessage mapMessage = (MapMessage) message;
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("subject_", mapMessage.getString("subject_"));
			mailSenderService.sendMail(maps);
		} catch (JMSException e) {
			logger.info("", e);
		}
	}

}
