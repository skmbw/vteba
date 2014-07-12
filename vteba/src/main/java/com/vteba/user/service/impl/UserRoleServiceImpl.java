package com.vteba.user.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.user.dao.IUserRoleDao;
import com.vteba.user.model.UserRole;
import com.vteba.user.service.IUserRoleService;

@Named
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, Long> implements IUserRoleService {

	public UserRoleServiceImpl() {
		super();
	}
	private IUserRoleDao userRoleDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<UserRole, Long> userRoleDaoImpl) {
		this.baseGenericDaoImpl = userRoleDaoImpl;
		this.userRoleDaoImpl = (IUserRoleDao) userRoleDaoImpl;
		
	}

	public IUserRoleDao getUserRoleDaoImpl() {
		return userRoleDaoImpl;
	}
	
	
}
