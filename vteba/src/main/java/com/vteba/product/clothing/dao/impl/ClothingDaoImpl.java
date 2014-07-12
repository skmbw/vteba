package com.vteba.product.clothing.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.BaseGenericDaoImpl;
import com.vteba.product.clothing.dao.spi.ClothingDao;
import com.vteba.product.clothing.model.Clothing;

/**
 * 衣服类商品Dao实现。
 * @author yinlei
 * date 2013-10-3 21:29:17
 */
@Named
public class ClothingDaoImpl extends BaseGenericDaoImpl<Clothing, Long> implements ClothingDao {
	
	public ClothingDaoImpl() {
		super();
	}

	public ClothingDaoImpl(Class<Clothing> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
