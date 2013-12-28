package com.vteba.community.collocation.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.community.collocation.dao.spi.CollocationTagDao;
import com.vteba.community.collocation.model.CollocationTag;

/**
 * 搭配标签Dao实现。
 * @author yinlei
 * date 2013-10-8 16:59:39
 */
@Named
public class CollocationTagDaoImpl extends HibernateGenericDaoImpl<CollocationTag, Integer> implements CollocationTagDao {
	
	public CollocationTagDaoImpl() {
		super();
	}

	public CollocationTagDaoImpl(Class<CollocationTag> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
