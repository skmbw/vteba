package com.vteba.user.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.BaseGenericDaoImpl;
import com.vteba.user.dao.IAuthResourceDao;
import com.vteba.user.model.AuthResource;

@Named
public class AuthResourceDaoImpl extends
		BaseGenericDaoImpl<AuthResource, Long> implements IAuthResourceDao {

	public AuthResourceDaoImpl() {
		super();
	}

	public AuthResourceDaoImpl(Class<AuthResource> entityClass) {
		super(entityClass);
	}
	
	@Inject
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
	}

}
