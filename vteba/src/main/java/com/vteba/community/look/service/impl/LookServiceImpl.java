package com.vteba.community.look.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tm.hibernate.IHibernateGenericDao;
import com.vteba.community.look.dao.spi.LookDao;
import com.vteba.community.look.model.Look;
import com.vteba.community.look.service.spi.LookService;

/**
 * 晒货商品Service实现。
 * @author yinlei
 * date 2013-10-5 22:16:00
 */
@Named
public class LookServiceImpl extends GenericServiceImpl<Look, Long> implements LookService {
	private LookDao lookDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Look, Long> lookDaoImpl) {
		this.hibernateGenericDaoImpl = lookDaoImpl;
		this.lookDaoImpl = (LookDao) lookDaoImpl;
		
	}

	/**
	 * @return the lookDaoImpl
	 */
	public LookDao getLookDaoImpl() {
		return lookDaoImpl;
	}

}
