package com.vteba.user.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.BaseGenericDaoImpl;
import com.vteba.tx.jdbc.spring.SpringJdbcTemplate;
import com.vteba.user.dao.spi.UserDao;
import com.vteba.user.model.User;

/**
 * 用户Dao实现。
 * @author yinlei
 * date 2013-8-31 0:45:14
 */
@Named
public class UserDaoImpl extends BaseGenericDaoImpl<User, Long> implements UserDao {
	
	public UserDaoImpl() {
		super();
	}

	public UserDaoImpl(Class<User> entityClass) {
		super(entityClass);
	}

	@Inject
	public void setSpringJdbcTemplate(SpringJdbcTemplate skmbwJdbcTemplate) {
		this.springJdbcTemplate = skmbwJdbcTemplate;
	}
	
	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

	

}
