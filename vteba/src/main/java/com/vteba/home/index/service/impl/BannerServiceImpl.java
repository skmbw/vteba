package com.vteba.home.index.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.home.index.dao.spi.BannerDao;
import com.vteba.home.index.model.Banner;
import com.vteba.home.index.service.spi.BannerService;

/**
 * 首页Banner Service实现。
 * @author yinlei
 * date 2013-8-31 21:00:21
 */
@Named
public class BannerServiceImpl extends GenericServiceImpl<Banner, Integer> implements BannerService {
	private BannerDao bannerDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Banner, Integer> bannerDaoImpl) {
		this.hibernateGenericDaoImpl = bannerDaoImpl;
		this.bannerDaoImpl = (BannerDao) bannerDaoImpl;
		
	}

	/**
	 * @return the bannerDaoImpl
	 */
	public BannerDao getBannerDaoImpl() {
		return bannerDaoImpl;
	}

}
