package com.vteba.community.base.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.community.base.dao.spi.ImagesDao;
import com.vteba.community.base.model.Images;

/**
 * 图片Dao实现。
 * @author yinlei
 * date 2013-10-7 16:41:32
 */
@Named
public class ImagesDaoImpl extends HibernateGenericDaoImpl<Images, Long> implements ImagesDao {
	
	public ImagesDaoImpl() {
		super();
	}

	public ImagesDaoImpl(Class<Images> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
