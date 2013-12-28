package com.vteba.community.base.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tm.hibernate.IHibernateGenericDao;
import com.vteba.community.base.dao.spi.ImagesDao;
import com.vteba.community.base.model.Images;
import com.vteba.community.base.service.spi.ImagesService;

/**
 * 图片Service实现。
 * @author yinlei
 * date 2013-10-7 16:41:32
 */
@Named
public class ImagesServiceImpl extends GenericServiceImpl<Images, Long> implements ImagesService {
	private ImagesDao imagesDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Images, Long> imagesDaoImpl) {
		this.hibernateGenericDaoImpl = imagesDaoImpl;
		this.imagesDaoImpl = (ImagesDao) imagesDaoImpl;
		
	}

	/**
	 * @return the imagesDaoImpl
	 */
	public ImagesDao getImagesDaoImpl() {
		return imagesDaoImpl;
	}

}
