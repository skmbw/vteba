package com.vteba.user.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vteba.tx.hibernate.impl.BaseGenericDaoImpl;
import com.vteba.user.dao.IUserRoleDao;
import com.vteba.user.model.UserRole;

@Named
public class UserRoleDaoImpl extends BaseGenericDaoImpl<UserRole, Long>
		implements IUserRoleDao {

	public UserRoleDaoImpl() {
		super();
	}

	public UserRoleDaoImpl(Class<UserRole> entityClass) {
		super(entityClass);
	}
	
	@Inject
	@Qualifier("skmbwSessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
