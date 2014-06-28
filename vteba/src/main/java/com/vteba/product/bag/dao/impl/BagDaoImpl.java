package com.vteba.product.bag.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.product.bag.dao.spi.BagDao;
import com.vteba.product.bag.model.Bag;
import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;

/**
 * 包包类商品Dao实现。
 * @author yinlei
 * date 2013-10-5 16:58:33
 */
@Named
public class BagDaoImpl extends HibernateGenericDaoImpl<Bag, Long> implements BagDao {
	
	public BagDaoImpl() {
		super();
	}

	public BagDaoImpl(Class<Bag> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
	}

	
	
}
