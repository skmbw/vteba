package com.vteba.jms.activemq.producer;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

@Named
public class MessageProducer {
	private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);
	private JmsTemplate jmsTemplate;
	private ActiveMQQueue onlineQueue;
	private ActiveMQQueue dyccQueue;
	private ActiveMQQueue logQueue;
	private String serverType;
	private String serverIp;
	private String serverName;

	public void sendOnlineQueue() {
		Map<String, String> onlineMap = new HashMap<String, String>();
		onlineMap.put("ONLINE_", "_ONLINE");
		onlineMap.put("serverType", this.serverType);
		onlineMap.put("serverIP", this.serverIp);
		onlineMap.put("serverName", this.serverName);

		sendMessage(this.onlineQueue, onlineMap);
	}

	public void sendDyccQueue(Map<String, String> dyccMap) {
		sendMessage(this.dyccQueue, dyccMap);
	}

	public void sendLogQueue(Map<String, String> logMap) {
		sendMessage(this.logQueue, logMap);
	}

	protected void sendMessage(Destination destination, final Map<String, String> map) {
		this.jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				MapMessage message = session.createMapMessage();
				if (map.containsKey("ONLINE_") && map.get("ONLINE_").equals("_ONLINE")) {
					for (String key : map.keySet()) {
						if (key.equals("ONLINE_")) {
							continue;
						}
						message.setStringProperty(key, map.get(key));
					}
					return message;
				}
				for (String key : map.keySet()) {
					message.setStringProperty(key, map.get(key));
				}
				return message;
			}
		});
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setOnlineQueue(ActiveMQQueue onlineQueue) {
		this.onlineQueue = onlineQueue;
	}

	public void setDyccQueue(ActiveMQQueue dyccQueue) {
		this.dyccQueue = dyccQueue;
	}

	public static String getLocalIP() {
		String ip = "";
		try {
			Enumeration<NetworkInterface> networkInterfaceEnum = NetworkInterface.getNetworkInterfaces();

			while (networkInterfaceEnum.hasMoreElements()) {
				NetworkInterface ni = networkInterfaceEnum.nextElement();
				if (!ni.getName().equals("eth0")) {
					continue;
				}
				Enumeration<InetAddress> inetAddressList = ni.getInetAddresses();
				while (inetAddressList.hasMoreElements()) {
					InetAddress inetAddress = inetAddressList.nextElement();
					if (inetAddress instanceof Inet6Address) {
						continue;
					}
					ip = inetAddress.getHostAddress();
				}
			}
		} catch (SocketException e) {
			logger.info("get local ip address error.", e);
		}
		return ip;
	}

	public static String byteHEX(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f' };

		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4 & 0xF)];
		ob[1] = Digit[(ib & 0xF)];
		String s = new String(ob);
		return s;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public void setLogQueue(ActiveMQQueue logQueue) {
		this.logQueue = logQueue;
	}
}
