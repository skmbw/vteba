package com.vteba.community.album.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.community.album.dao.spi.AlbumTypeDao;
import com.vteba.community.album.model.AlbumType;
import com.vteba.community.album.service.spi.AlbumTypeService;

/**
 * 专辑类型Service实现。
 * @author yinlei
 * date 2013-10-7 21:46:38
 */
@Named
public class AlbumTypeServiceImpl extends BaseServiceImpl<AlbumType, Integer> implements AlbumTypeService {
	private AlbumTypeDao albumTypeDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<AlbumType, Integer> albumTypeDaoImpl) {
		this.baseGenericDaoImpl = albumTypeDaoImpl;
		this.albumTypeDaoImpl = (AlbumTypeDao) albumTypeDaoImpl;
		
	}

	/**
	 * @return the albumTypeDaoImpl
	 */
	public AlbumTypeDao getAlbumTypeDaoImpl() {
		return albumTypeDaoImpl;
	}

}
