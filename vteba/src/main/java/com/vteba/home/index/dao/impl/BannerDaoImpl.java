package com.vteba.home.index.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.home.index.dao.spi.BannerDao;
import com.vteba.home.index.model.Banner;

/**
 * 首页Banner Dao实现。
 * @author yinlei
 * date 2013-8-31 21:00:21
 */
@Named
public class BannerDaoImpl extends HibernateGenericDaoImpl<Banner, Integer> implements BannerDao {
	
	public BannerDaoImpl() {
		super();
	}

	public BannerDaoImpl(Class<Banner> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
