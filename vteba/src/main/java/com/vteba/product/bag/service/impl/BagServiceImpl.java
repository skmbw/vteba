package com.vteba.product.bag.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.product.bag.dao.spi.BagDao;
import com.vteba.product.bag.model.Bag;
import com.vteba.product.bag.service.spi.BagService;

/**
 * 包包类商品Service实现。
 * @author yinlei
 * date 2013-10-5 16:58:33
 */
@Named
public class BagServiceImpl extends GenericServiceImpl<Bag, Long> implements BagService {
	private BagDao bagDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Bag, Long> bagDaoImpl) {
		this.hibernateGenericDaoImpl = bagDaoImpl;
		this.bagDaoImpl = (BagDao) bagDaoImpl;
		
	}

	/**
	 * @return the bagDaoImpl
	 */
	public BagDao getBagDaoImpl() {
		return bagDaoImpl;
	}

}
