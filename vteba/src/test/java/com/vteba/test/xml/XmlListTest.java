package com.vteba.test.xml;

import java.util.List;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;
import com.vteba.user.model.User;

public class XmlListTest {

	public static void main(String[] args) {
		XStream xstream = new XStream();
		List<User> userList = Lists.newArrayList();
		User user = new User();
		user.setAddress("asdf");
		user.setAuthCode("aaaa");
		userList.add(user);
		
		String xml = xstream.toXML(userList);
		System.out.println(xml);

	}

}
