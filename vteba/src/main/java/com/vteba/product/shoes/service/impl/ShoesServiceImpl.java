package com.vteba.product.shoes.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.product.shoes.dao.spi.ShoesDao;
import com.vteba.product.shoes.model.Shoes;
import com.vteba.product.shoes.service.spi.ShoesService;

/**
 * 鞋类商品Service实现。
 * @author yinlei
 * date 2013-10-3 20:56:49
 */
@Named
public class ShoesServiceImpl extends BaseServiceImpl<Shoes, Long> implements ShoesService {
	private ShoesDao shoesDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Shoes, Long> shoesDaoImpl) {
		this.baseGenericDaoImpl = shoesDaoImpl;
		this.shoesDaoImpl = (ShoesDao) shoesDaoImpl;
		
	}

	/**
	 * @return the shoesDaoImpl
	 */
	public ShoesDao getShoesDaoImpl() {
		return shoesDaoImpl;
	}

	@Override
	public Shoes test() {
		
		return shoesDaoImpl.get(1L);
	}

}
