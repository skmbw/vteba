package com.vteba.user.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;

import com.vteba.tx.hibernate.impl.BaseGenericDaoImpl;
import com.vteba.user.dao.IRolesDao;
import com.vteba.user.model.Roles;

/**
 * 
 * @author yinlei
 * date 2013-8-27 下午9:27:49
 */
@Named
public class RolesDaoImpl extends BaseGenericDaoImpl<Roles, Long>
		implements IRolesDao {

	public RolesDaoImpl() {
		super();
	}

	public RolesDaoImpl(Class<Roles> entityClass) {
		super(entityClass);
	}
	
	@Inject
	@Qualifier("skmbwSessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
