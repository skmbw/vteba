package com.vteba.community.collocation.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tm.hibernate.IHibernateGenericDao;
import com.vteba.community.collocation.dao.spi.CollocationTagDao;
import com.vteba.community.collocation.model.CollocationTag;
import com.vteba.community.collocation.service.spi.CollocationTagService;

/**
 * 搭配标签Service实现。
 * @author yinlei
 * date 2013-10-8 16:59:39
 */
@Named
public class CollocationTagServiceImpl extends GenericServiceImpl<CollocationTag, Integer> implements CollocationTagService {
	private CollocationTagDao collocationTagDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<CollocationTag, Integer> collocationTagDaoImpl) {
		this.hibernateGenericDaoImpl = collocationTagDaoImpl;
		this.collocationTagDaoImpl = (CollocationTagDao) collocationTagDaoImpl;
		
	}

	/**
	 * @return the collocationTagDaoImpl
	 */
	public CollocationTagDao getCollocationTagDaoImpl() {
		return collocationTagDaoImpl;
	}

}
