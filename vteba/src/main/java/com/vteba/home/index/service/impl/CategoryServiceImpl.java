package com.vteba.home.index.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.home.index.dao.spi.CategoryDao;
import com.vteba.home.index.model.Category;
import com.vteba.home.index.service.spi.CategoryService;

/**
 * 商品分类Service实现。
 * @author yinlei
 * date 2013-8-31 21:00:53
 */
@Named
public class CategoryServiceImpl extends GenericServiceImpl<Category, Integer> implements CategoryService {
	private CategoryDao categoryDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Category, Integer> categoryDaoImpl) {
		this.hibernateGenericDaoImpl = categoryDaoImpl;
		this.categoryDaoImpl = (CategoryDao) categoryDaoImpl;
		
	}

	/**
	 * @return the categoryDaoImpl
	 */
	public CategoryDao getCategoryDaoImpl() {
		return categoryDaoImpl;
	}

}
