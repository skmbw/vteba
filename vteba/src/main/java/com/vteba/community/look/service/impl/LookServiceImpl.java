package com.vteba.community.look.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.community.look.dao.spi.LookDao;
import com.vteba.community.look.model.Look;
import com.vteba.community.look.service.spi.LookService;

/**
 * 晒货商品Service实现。
 * @author yinlei
 * date 2013-10-5 22:16:00
 */
@Named
public class LookServiceImpl extends BaseServiceImpl<Look, Long> implements LookService {
	private LookDao lookDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Look, Long> lookDaoImpl) {
		this.baseGenericDaoImpl = lookDaoImpl;
		this.lookDaoImpl = (LookDao) lookDaoImpl;
		
	}

	/**
	 * @return the lookDaoImpl
	 */
	public LookDao getLookDaoImpl() {
		return lookDaoImpl;
	}

}
