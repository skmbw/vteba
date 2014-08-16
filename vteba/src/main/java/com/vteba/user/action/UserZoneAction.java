package com.vteba.user.action;

import java.io.Serializable;

import com.vteba.service.generic.BaseService;
import com.vteba.user.model.User;
import com.vteba.web.action.BasicAction;

/**
 * 用户空间控制器。
 * @author yinlei
 * date 2013-8-25 下午5:49:21
 */
public class UserZoneAction extends BasicAction<User> {

	@Override
	public void setBaseServiceImpl(
			BaseService<User, ? extends Serializable> BaseServiceImpl) {
		
		
	}

}
