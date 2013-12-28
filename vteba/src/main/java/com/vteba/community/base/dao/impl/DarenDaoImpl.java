package com.vteba.community.base.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.community.base.dao.spi.DarenDao;
import com.vteba.community.base.model.Daren;

/**
 * 社区达人Dao实现。
 * @author yinlei
 * date 2013-10-7 15:17:07
 */
@Named
public class DarenDaoImpl extends HibernateGenericDaoImpl<Daren, Long> implements DarenDao {
	
	public DarenDaoImpl() {
		super();
	}

	public DarenDaoImpl(Class<Daren> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
