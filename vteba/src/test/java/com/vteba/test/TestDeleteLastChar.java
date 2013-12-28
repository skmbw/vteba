package com.vteba.test;

import org.apache.commons.lang3.StringUtils;

public class TestDeleteLastChar {

	/**
	 * @param args
	 * @author yinlei
	 * date 2013-8-25 下午9:35:05
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String url = "http://localhost/index/";
		System.out.println(url.endsWith("/"));
		
		int times = 100000;
		String s1 = "";
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			s1 = url.substring(0, url.length() - 1);
		}
		System.out.println(System.currentTimeMillis() - t1);
		
		String s2 = "";
		long t2 = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			s2 = StringUtils.substring(url, 0, url.length() - 1);
		}
		System.out.println(System.currentTimeMillis() - t2);
		
		String s3 = "";
		long t3 = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			s3 = StringUtils.left(url, url.length() - 1);
		}
		System.out.println(System.currentTimeMillis() - t3);
	}

}
