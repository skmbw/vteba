package com.vteba.product.accessories.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.product.accessories.dao.spi.AccessoriesDao;
import com.vteba.product.accessories.model.Accessories;

/**
 * 配饰类商品Dao实现。
 * @author yinlei
 * date 2013-10-5 16:57:27
 */
@Named
public class AccessoriesDaoImpl extends HibernateGenericDaoImpl<Accessories, Long> implements AccessoriesDao {
	
	public AccessoriesDaoImpl() {
		super();
	}

	public AccessoriesDaoImpl(Class<Accessories> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
