package com.vteba.product.men.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.product.men.dao.spi.MenDao;
import com.vteba.product.men.model.Men;

/**
 * 男装类商品Dao实现。
 * @author yinlei
 * date 2013-10-5 17:00:08
 */
@Named
public class MenDaoImpl extends HibernateGenericDaoImpl<Men, Long> implements MenDao {
	
	public MenDaoImpl() {
		super();
	}

	public MenDaoImpl(Class<Men> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
