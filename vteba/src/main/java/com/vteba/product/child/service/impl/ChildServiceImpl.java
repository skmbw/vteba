package com.vteba.product.child.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.product.child.dao.spi.ChildDao;
import com.vteba.product.child.model.Child;
import com.vteba.product.child.service.spi.ChildService;

/**
 * 亲子类商品Service实现。
 * @author yinlei
 * date 2013-10-5 16:59:22
 */
@Named
public class ChildServiceImpl extends BaseServiceImpl<Child, Long> implements ChildService {
	private ChildDao childDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Child, Long> childDaoImpl) {
		this.baseGenericDaoImpl = childDaoImpl;
		this.childDaoImpl = (ChildDao) childDaoImpl;
		
	}

	/**
	 * @return the childDaoImpl
	 */
	public ChildDao getChildDaoImpl() {
		return childDaoImpl;
	}

}
