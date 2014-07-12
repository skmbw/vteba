package com.vteba.community.base.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.community.base.dao.spi.DarenDao;
import com.vteba.community.base.model.Daren;
import com.vteba.community.base.service.spi.DarenService;

/**
 * 社区达人Service实现。
 * @author yinlei
 * date 2013-10-7 15:17:07
 */
@Named
public class DarenServiceImpl extends BaseServiceImpl<Daren, Long> implements DarenService {
	private DarenDao darenDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Daren, Long> darenDaoImpl) {
		this.baseGenericDaoImpl = darenDaoImpl;
		this.darenDaoImpl = (DarenDao) darenDaoImpl;
		
	}

	/**
	 * @return the darenDaoImpl
	 */
	public DarenDao getDarenDaoImpl() {
		return darenDaoImpl;
	}

}
