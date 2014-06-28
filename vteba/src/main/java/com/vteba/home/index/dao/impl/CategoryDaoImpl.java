package com.vteba.home.index.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.home.index.dao.spi.CategoryDao;
import com.vteba.home.index.model.Category;

/**
 * 商品分类Dao实现。
 * @author yinlei
 * date 2013-8-31 21:00:53
 */
@Named
public class CategoryDaoImpl extends HibernateGenericDaoImpl<Category, Integer> implements CategoryDao {
	
	public CategoryDaoImpl() {
		super();
	}

	public CategoryDaoImpl(Class<Category> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
