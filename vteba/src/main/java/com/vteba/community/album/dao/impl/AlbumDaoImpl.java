package com.vteba.community.album.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.community.album.dao.spi.AlbumDao;
import com.vteba.community.album.model.Album;

/**
 * 专辑Dao实现。
 * @author yinlei
 * date 2013-10-7 16:40:37
 */
@Named
public class AlbumDaoImpl extends HibernateGenericDaoImpl<Album, Long> implements AlbumDao {
	
	public AlbumDaoImpl() {
		super();
	}

	public AlbumDaoImpl(Class<Album> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
