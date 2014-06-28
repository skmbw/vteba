package com.vteba.product.home.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.product.home.dao.spi.HomeDao;
import com.vteba.product.home.model.Home;
import com.vteba.product.home.service.spi.HomeService;

/**
 * 家居类商品Service实现。
 * @author yinlei
 * date 2013-10-5 16:59:47
 */
@Named
public class HomeServiceImpl extends GenericServiceImpl<Home, Long> implements HomeService {
	private HomeDao homeDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Home, Long> homeDaoImpl) {
		this.hibernateGenericDaoImpl = homeDaoImpl;
		this.homeDaoImpl = (HomeDao) homeDaoImpl;
		
	}

	/**
	 * @return the homeDaoImpl
	 */
	public HomeDao getHomeDaoImpl() {
		return homeDaoImpl;
	}

}
