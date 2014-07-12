package com.vteba.user.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.user.dao.IAuthResourceDao;
import com.vteba.user.model.AuthResource;
import com.vteba.user.service.IAuthResourceService;

@Named
public class AuthResourceServiceImpl extends BaseServiceImpl<AuthResource, Long> implements IAuthResourceService {
	
	public AuthResourceServiceImpl() {
		super();
	}
	private IAuthResourceDao authResourceDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<AuthResource, Long> authResourceDaoImpl) {
		this.baseGenericDaoImpl = authResourceDaoImpl;
		this.authResourceDaoImpl = (IAuthResourceDao) authResourceDaoImpl;
		
	}

	public IAuthResourceDao getAuthResourceDaoImpl() {
		return authResourceDaoImpl;
	}
	
	public List<AuthResource> getAllList() {
		return authResourceDaoImpl.getAll();
	}
}
