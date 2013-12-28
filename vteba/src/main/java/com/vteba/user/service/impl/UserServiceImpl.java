package com.vteba.user.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tm.hibernate.IHibernateGenericDao;
import com.vteba.user.dao.spi.UserDao;
import com.vteba.user.model.User;
import com.vteba.user.service.spi.UserService;

/**
 * 用户Service实现。
 * @author yinlei
 * date 2013-8-31 0:45:14
 */
@Named
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
	private UserDao userDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<User, Long> userDaoImpl) {
		this.hibernateGenericDaoImpl = userDaoImpl;
		this.userDaoImpl = (UserDao) userDaoImpl;
		this.springJdbcTemplate = this.userDaoImpl.getSpringJdbcTemplate();
	}

}
