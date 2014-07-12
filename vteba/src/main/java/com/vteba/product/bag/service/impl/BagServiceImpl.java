package com.vteba.product.bag.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.product.bag.dao.spi.BagDao;
import com.vteba.product.bag.model.Bag;
import com.vteba.product.bag.service.spi.BagService;

/**
 * 包包类商品Service实现。
 * @author yinlei
 * date 2013-10-5 16:58:33
 */
@Named
public class BagServiceImpl extends BaseServiceImpl<Bag, Long> implements BagService {
	private BagDao bagDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Bag, Long> bagDaoImpl) {
		this.baseGenericDaoImpl = bagDaoImpl;
		this.bagDaoImpl = (BagDao) bagDaoImpl;
		
	}

	/**
	 * @return the bagDaoImpl
	 */
	public BagDao getBagDaoImpl() {
		return bagDaoImpl;
	}

}
