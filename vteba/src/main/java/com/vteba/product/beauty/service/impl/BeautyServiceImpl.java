package com.vteba.product.beauty.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tm.hibernate.IHibernateGenericDao;
import com.vteba.product.beauty.dao.spi.BeautyDao;
import com.vteba.product.beauty.model.Beauty;
import com.vteba.product.beauty.service.spi.BeautyService;

/**
 * 美妆类商品Service实现。
 * @author yinlei
 * date 2013-10-5 16:58:57
 */
@Named
public class BeautyServiceImpl extends GenericServiceImpl<Beauty, Long> implements BeautyService {
	private BeautyDao beautyDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Beauty, Long> beautyDaoImpl) {
		this.hibernateGenericDaoImpl = beautyDaoImpl;
		this.beautyDaoImpl = (BeautyDao) beautyDaoImpl;
		
	}

	/**
	 * @return the beautyDaoImpl
	 */
	public BeautyDao getBeautyDaoImpl() {
		return beautyDaoImpl;
	}

}
