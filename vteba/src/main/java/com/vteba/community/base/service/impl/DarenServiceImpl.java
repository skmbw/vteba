package com.vteba.community.base.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tm.hibernate.IHibernateGenericDao;
import com.vteba.community.base.dao.spi.DarenDao;
import com.vteba.community.base.model.Daren;
import com.vteba.community.base.service.spi.DarenService;

/**
 * 社区达人Service实现。
 * @author yinlei
 * date 2013-10-7 15:17:07
 */
@Named
public class DarenServiceImpl extends GenericServiceImpl<Daren, Long> implements DarenService {
	private DarenDao darenDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Daren, Long> darenDaoImpl) {
		this.hibernateGenericDaoImpl = darenDaoImpl;
		this.darenDaoImpl = (DarenDao) darenDaoImpl;
		
	}

	/**
	 * @return the darenDaoImpl
	 */
	public DarenDao getDarenDaoImpl() {
		return darenDaoImpl;
	}

}
