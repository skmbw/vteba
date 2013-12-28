package com.vteba.product.child.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.product.child.dao.spi.ChildDao;
import com.vteba.product.child.model.Child;

/**
 * 亲子类商品Dao实现。
 * @author yinlei
 * date 2013-10-5 16:59:22
 */
@Named
public class ChildDaoImpl extends HibernateGenericDaoImpl<Child, Long> implements ChildDao {
	
	public ChildDaoImpl() {
		super();
	}

	public ChildDaoImpl(Class<Child> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
