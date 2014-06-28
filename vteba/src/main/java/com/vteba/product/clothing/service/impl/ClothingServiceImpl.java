package com.vteba.product.clothing.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.product.clothing.dao.spi.ClothingDao;
import com.vteba.product.clothing.model.Clothing;
import com.vteba.product.clothing.service.spi.ClothingService;
import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tx.hibernate.IHibernateGenericDao;

/**
 * 衣服类商品Service实现。
 * @author yinlei
 * date 2013-10-3 21:29:17
 */
@Named
public class ClothingServiceImpl extends GenericServiceImpl<Clothing, Long> implements ClothingService {
	private ClothingDao clothingDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Clothing, Long> clothingDaoImpl) {
		this.hibernateGenericDaoImpl = clothingDaoImpl;
		this.clothingDaoImpl = (ClothingDao) clothingDaoImpl;
		
	}

	/**
	 * @return the clothingDaoImpl
	 */
	public ClothingDao getClothingDaoImpl() {
		return clothingDaoImpl;
	}


}
