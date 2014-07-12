package com.vteba.user.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.user.dao.IRoleAuthDao;
import com.vteba.user.model.RoleAuth;
import com.vteba.user.service.IRoleAuthService;

@Named
public class RoleAuthServiceImpl extends BaseServiceImpl<RoleAuth, Long> implements IRoleAuthService {

	public RoleAuthServiceImpl() {
		super();
	}
	private IRoleAuthDao roleAuthDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<RoleAuth, Long> roleAuthDaoImpl) {
		this.baseGenericDaoImpl = roleAuthDaoImpl;
		this.roleAuthDaoImpl = (IRoleAuthDao) roleAuthDaoImpl;
		
	}

	public IRoleAuthDao getRoleAuthDaoImpl() {
		return roleAuthDaoImpl;
	}
	
}
