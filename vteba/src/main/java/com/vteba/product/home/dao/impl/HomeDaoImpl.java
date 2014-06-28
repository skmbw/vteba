package com.vteba.product.home.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.product.home.dao.spi.HomeDao;
import com.vteba.product.home.model.Home;

/**
 * 家居类商品Dao实现。
 * @author yinlei
 * date 2013-10-5 16:59:47
 */
@Named
public class HomeDaoImpl extends HibernateGenericDaoImpl<Home, Long> implements HomeDao {
	
	public HomeDaoImpl() {
		super();
	}

	public HomeDaoImpl(Class<Home> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
