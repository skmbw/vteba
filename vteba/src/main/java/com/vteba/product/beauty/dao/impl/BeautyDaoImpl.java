package com.vteba.product.beauty.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.BaseGenericDaoImpl;
import com.vteba.product.beauty.dao.spi.BeautyDao;
import com.vteba.product.beauty.model.Beauty;

/**
 * 美妆类商品Dao实现。
 * @author yinlei
 * date 2013-10-5 16:58:57
 */
@Named
public class BeautyDaoImpl extends BaseGenericDaoImpl<Beauty, Long> implements BeautyDao {
	
	public BeautyDaoImpl() {
		super();
	}

	public BeautyDaoImpl(Class<Beauty> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
