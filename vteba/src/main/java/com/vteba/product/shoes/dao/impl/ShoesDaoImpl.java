package com.vteba.product.shoes.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.product.shoes.dao.spi.ShoesDao;
import com.vteba.product.shoes.model.Shoes;

/**
 * 鞋类商品Dao实现。
 * @author yinlei
 * date 2013-10-3 20:56:49
 */
@Named
public class ShoesDaoImpl extends HibernateGenericDaoImpl<Shoes, Long> implements ShoesDao {
	
	public ShoesDaoImpl() {
		super();
	}

	public ShoesDaoImpl(Class<Shoes> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
