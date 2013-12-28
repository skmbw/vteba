package com.vteba.community.collocation.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.community.collocation.dao.spi.CollocationDao;
import com.vteba.community.collocation.model.Collocation;

/**
 * 搭配推荐商品Dao实现。
 * @author yinlei
 * date 2013-10-5 17:10:30
 */
@Named
public class CollocationDaoImpl extends HibernateGenericDaoImpl<Collocation, Long> implements CollocationDao {
	
	public CollocationDaoImpl() {
		super();
	}

	public CollocationDaoImpl(Class<Collocation> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
