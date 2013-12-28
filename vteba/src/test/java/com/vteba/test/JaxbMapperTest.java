package com.vteba.test;

import com.thoughtworks.xstream.XStream;
import com.vteba.util.mapper.JaxbMapper;

@SuppressWarnings("deprecation")
public class JaxbMapperTest {

	/**
	 * @param args
	 * @author yinlei
	 * date 2013-9-15 下午3:22:55
	 */
	public static void main(String[] args) {
		UserCopy user = new UserCopy();
		user.setUserId(1L);
		user.setAddress("addr");
		user.setCity("hang");
		int times = 1000;
		
		long d = System.currentTimeMillis();
		System.out.println(JaxbMapper.toXml(user));
		for (int i = 0; i < times; i++) {
			JaxbMapper.toXml(user);
		}
		System.out.println(System.currentTimeMillis() - d);
		
		
		XStream xstream = new XStream();
		long d1 = System.currentTimeMillis();
		System.out.println(xstream.toXML(user));
		for (int i = 0; i < times; i++) {
			xstream.toXML(user);
		}
		System.out.println(System.currentTimeMillis() - d1);
	}

}
