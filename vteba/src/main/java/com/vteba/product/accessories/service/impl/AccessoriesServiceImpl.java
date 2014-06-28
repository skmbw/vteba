package com.vteba.product.accessories.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.product.accessories.dao.spi.AccessoriesDao;
import com.vteba.product.accessories.model.Accessories;
import com.vteba.product.accessories.service.spi.AccessoriesService;

/**
 * 配饰类商品Service实现。
 * @author yinlei
 * date 2013-10-5 16:57:27
 */
@Named
public class AccessoriesServiceImpl extends GenericServiceImpl<Accessories, Long> implements AccessoriesService {
	private AccessoriesDao accessoriesDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Accessories, Long> accessoriesDaoImpl) {
		this.hibernateGenericDaoImpl = accessoriesDaoImpl;
		this.accessoriesDaoImpl = (AccessoriesDao) accessoriesDaoImpl;
		
	}

	/**
	 * @return the accessoriesDaoImpl
	 */
	public AccessoriesDao getAccessoriesDaoImpl() {
		return accessoriesDaoImpl;
	}

}
