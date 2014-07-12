package com.vteba.user.service;

import java.util.List;

import com.vteba.service.generic.BaseService;
import com.vteba.user.model.AuthResource;

public interface IAuthResourceService extends BaseService<AuthResource, Long> {
	
	public List<AuthResource> getAllList();
}
