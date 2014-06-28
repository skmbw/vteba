package com.vteba.user.action;

import java.io.Serializable;

import com.vteba.service.generic.IGenericService;
import com.vteba.user.model.User;
import com.vteba.web.action.BaseAction;

/**
 * 用户空间控制器。
 * @author yinlei
 * date 2013-8-25 下午5:49:21
 */
public class UserZoneAction extends BaseAction<User> {

	@Override
	public void setGenericServiceImpl(
			IGenericService<User, ? extends Serializable> genericServiceImpl) {
		
		
	}

}
