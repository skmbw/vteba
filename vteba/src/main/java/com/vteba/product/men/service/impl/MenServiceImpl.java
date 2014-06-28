package com.vteba.product.men.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.product.men.dao.spi.MenDao;
import com.vteba.product.men.model.Men;
import com.vteba.product.men.service.spi.MenService;

/**
 * 男装类商品Service实现。
 * @author yinlei
 * date 2013-10-5 17:00:08
 */
@Named
public class MenServiceImpl extends GenericServiceImpl<Men, Long> implements MenService {
	private MenDao menDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Men, Long> menDaoImpl) {
		this.hibernateGenericDaoImpl = menDaoImpl;
		this.menDaoImpl = (MenDao) menDaoImpl;
		
	}

	/**
	 * @return the menDaoImpl
	 */
	public MenDao getMenDaoImpl() {
		return menDaoImpl;
	}

}
