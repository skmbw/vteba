package com.vteba.community.album.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.community.album.dao.spi.AlbumDao;
import com.vteba.community.album.model.Album;
import com.vteba.community.album.service.spi.AlbumService;

/**
 * 专辑Service实现。
 * @author yinlei
 * date 2013-10-7 16:40:37
 */
@Named
public class AlbumServiceImpl extends BaseServiceImpl<Album, Long> implements AlbumService {
	private AlbumDao albumDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Album, Long> albumDaoImpl) {
		this.baseGenericDaoImpl = albumDaoImpl;
		this.albumDaoImpl = (AlbumDao) albumDaoImpl;
		
	}

	/**
	 * @return the albumDaoImpl
	 */
	public AlbumDao getAlbumDaoImpl() {
		return albumDaoImpl;
	}

}
