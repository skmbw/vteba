package com.vteba.home.index.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.home.index.dao.spi.CategoryDao;
import com.vteba.home.index.model.Category;
import com.vteba.home.index.service.spi.CategoryService;

/**
 * 商品分类Service实现。
 * @author yinlei
 * date 2013-8-31 21:00:53
 */
@Named
public class CategoryServiceImpl extends BaseServiceImpl<Category, Integer> implements CategoryService {
	private CategoryDao categoryDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Category, Integer> categoryDaoImpl) {
		this.baseGenericDaoImpl = categoryDaoImpl;
		this.categoryDaoImpl = (CategoryDao) categoryDaoImpl;
		
	}

	/**
	 * @return the categoryDaoImpl
	 */
	public CategoryDao getCategoryDaoImpl() {
		return categoryDaoImpl;
	}

}
