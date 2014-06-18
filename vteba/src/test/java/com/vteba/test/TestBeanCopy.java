package com.vteba.test;

import com.vteba.user.model.User;
import com.vteba.utils.mapper.BeanMapper;
import com.vteba.utils.reflection.BeanCopyUtils;

@SuppressWarnings("deprecation")
public class TestBeanCopy {

	/**
	 * @param args
	 * @author yinlei
	 * date 2013-9-15 下午3:07:32
	 */
	public static void main(String[] args) {
		User user = new User();
		user.setUserId(1L);
		user.setAddress("addr");
		user.setAuthCode("asdf");
		
		int times = 10000;
		
		long d1 = System.currentTimeMillis();
		UserCopy tempUser = new UserCopy();
		for (int i = 0; i < times; i++) {
			
			BeanMapper.copy(user, tempUser);
		}
		System.out.println(System.currentTimeMillis() - d1);
		
		long d2 = System.currentTimeMillis();
		UserCopy tempUser1 = new UserCopy();
		for (int i = 0; i < times; i++) {
			BeanCopyUtils.get().beanCopy(user, tempUser1);
		}
		System.out.println(System.currentTimeMillis() - d2);
	}

}
