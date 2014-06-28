package com.vteba.community.look.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.community.look.dao.spi.LookDao;
import com.vteba.community.look.model.Look;

/**
 * 晒货商品Dao实现。
 * @author yinlei
 * date 2013-10-5 22:16:00
 */
@Named
public class LookDaoImpl extends HibernateGenericDaoImpl<Look, Long> implements LookDao {
	
	public LookDaoImpl() {
		super();
	}

	public LookDaoImpl(Class<Look> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
