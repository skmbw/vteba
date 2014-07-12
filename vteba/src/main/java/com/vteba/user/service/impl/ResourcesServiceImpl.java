package com.vteba.user.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.user.dao.IResourcesDao;
import com.vteba.user.model.Resources;
import com.vteba.user.service.IResourcesService;

@Deprecated
@Named
public class ResourcesServiceImpl extends BaseServiceImpl<Resources, Long> implements IResourcesService {

	public ResourcesServiceImpl() {
		super();
	}
	private IResourcesDao resourcesDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Resources, Long> resourcesDaoImpl) {
		this.baseGenericDaoImpl = resourcesDaoImpl;
		this.resourcesDaoImpl = (IResourcesDao) resourcesDaoImpl;
		
	}

	public IResourcesDao getResourcesDaoImpl() {
		return resourcesDaoImpl;
	}
	
	
}
