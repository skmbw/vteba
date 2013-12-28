package com.vteba.community.album.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.community.album.dao.spi.AlbumTypeDao;
import com.vteba.community.album.model.AlbumType;

/**
 * 专辑类型Dao实现。
 * @author yinlei
 * date 2013-10-7 21:46:38
 */
@Named
public class AlbumTypeDaoImpl extends HibernateGenericDaoImpl<AlbumType, Integer> implements AlbumTypeDao {
	
	public AlbumTypeDaoImpl() {
		super();
	}

	public AlbumTypeDaoImpl(Class<AlbumType> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
