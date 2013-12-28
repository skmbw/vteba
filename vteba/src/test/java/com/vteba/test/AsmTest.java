package com.vteba.test;

import com.vteba.lang.bytecode.FieldAccess;
import com.vteba.lang.bytecode.MethodAccess;
import com.vteba.user.model.User;

public class AsmTest {

	/**
	 * @param args
	 * @author yinlei
	 * date 2013-9-20 下午4:58:33
	 */
	public static void main(String[] args) {
		User user = new User();
		user.setAddress("addr");
		user.setAuthCode("12df");
		
		FieldAccess fieldAccess = FieldAccess.get(User.class);
		
		System.out.println(fieldAccess.get(user, "address"));
		
		MethodAccess methodAccess = MethodAccess.get(User.class);
		
		System.out.println(methodAccess.invoke(user, "getAddr", (Object[])null));
	}

}
