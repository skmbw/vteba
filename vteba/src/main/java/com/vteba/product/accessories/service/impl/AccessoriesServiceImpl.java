package com.vteba.product.accessories.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.product.accessories.dao.spi.AccessoriesDao;
import com.vteba.product.accessories.model.Accessories;
import com.vteba.product.accessories.service.spi.AccessoriesService;

/**
 * 配饰类商品Service实现。
 * @author yinlei
 * date 2013-10-5 16:57:27
 */
@Named
public class AccessoriesServiceImpl extends BaseServiceImpl<Accessories, Long> implements AccessoriesService {
	private AccessoriesDao accessoriesDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Accessories, Long> accessoriesDaoImpl) {
		this.baseGenericDaoImpl = accessoriesDaoImpl;
		this.accessoriesDaoImpl = (AccessoriesDao) accessoriesDaoImpl;
		
	}

	/**
	 * @return the accessoriesDaoImpl
	 */
	public AccessoriesDao getAccessoriesDaoImpl() {
		return accessoriesDaoImpl;
	}

}
