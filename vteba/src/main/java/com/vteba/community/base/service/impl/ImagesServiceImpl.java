package com.vteba.community.base.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.community.base.dao.spi.ImagesDao;
import com.vteba.community.base.model.Images;
import com.vteba.community.base.service.spi.ImagesService;

/**
 * 图片Service实现。
 * @author yinlei
 * date 2013-10-7 16:41:32
 */
@Named
public class ImagesServiceImpl extends BaseServiceImpl<Images, Long> implements ImagesService {
	private ImagesDao imagesDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Images, Long> imagesDaoImpl) {
		this.baseGenericDaoImpl = imagesDaoImpl;
		this.imagesDaoImpl = (ImagesDao) imagesDaoImpl;
		
	}

	/**
	 * @return the imagesDaoImpl
	 */
	public ImagesDao getImagesDaoImpl() {
		return imagesDaoImpl;
	}

}
