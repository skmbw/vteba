package com.vteba.product.base.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.product.base.dao.spi.TagsDao;
import com.vteba.product.base.model.Tags;

/**
 * 商品标签Dao实现。
 * @author yinlei
 * date 2013-10-4 17:53:44
 */
@Named
public class TagsDaoImpl extends HibernateGenericDaoImpl<Tags, Integer> implements TagsDao {
	
	public TagsDaoImpl() {
		super();
	}

	public TagsDaoImpl(Class<Tags> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
