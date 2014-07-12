package com.vteba.user.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.user.dao.IRolesDao;
import com.vteba.user.model.Roles;
import com.vteba.user.service.IRolesService;

@Named
public class RolesServiceImpl extends BaseServiceImpl<Roles, Long> implements IRolesService {
	
	public RolesServiceImpl() {
		super();
	}
	
	private IRolesDao rolesDaoImpl;
		
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Roles, Long> rolesDaoImpl) {
		this.baseGenericDaoImpl = rolesDaoImpl;
		this.rolesDaoImpl = (IRolesDao) rolesDaoImpl;
	}

	public IRolesDao getRolesDaoImpl() {
		return rolesDaoImpl;
	}	

}
