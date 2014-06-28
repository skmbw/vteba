package com.vteba.community.collocation.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.community.collocation.dao.spi.CollocationDao;
import com.vteba.community.collocation.model.Collocation;
import com.vteba.community.collocation.service.spi.CollocationService;

/**
 * 搭配推荐商品Service实现。
 * @author yinlei
 * date 2013-10-5 17:10:30
 */
@Named
public class CollocationServiceImpl extends GenericServiceImpl<Collocation, Long> implements CollocationService {
	private CollocationDao collocationDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Collocation, Long> collocationDaoImpl) {
		this.hibernateGenericDaoImpl = collocationDaoImpl;
		this.collocationDaoImpl = (CollocationDao) collocationDaoImpl;
		
	}

	/**
	 * @return the collocationDaoImpl
	 */
	public CollocationDao getCollocationDaoImpl() {
		return collocationDaoImpl;
	}

}
