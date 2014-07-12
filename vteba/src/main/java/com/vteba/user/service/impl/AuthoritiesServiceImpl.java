package com.vteba.user.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.security.spi.AuthoritiesService;
import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.user.dao.IAuthoritiesDao;
import com.vteba.user.model.Authorities;
import com.vteba.user.service.IAuthoritiesService;

@Named
public class AuthoritiesServiceImpl extends BaseServiceImpl<Authorities, Long> implements IAuthoritiesService, AuthoritiesService {

	public AuthoritiesServiceImpl() {
		super();
	}
	
	private IAuthoritiesDao authoritiesDaoImpl;
		
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Authorities, Long> authoritiesDaoImpl) {
		this.baseGenericDaoImpl = authoritiesDaoImpl;
		this.authoritiesDaoImpl = (IAuthoritiesDao) authoritiesDaoImpl;
		
	}

	public IAuthoritiesDao getAuthoritiesDaoImpl() {
		return authoritiesDaoImpl;
	}

	public List<String> getAllAuthorities() {
		List<String> authList = new ArrayList<String>();
		String hql = "select a.authName from Authorities a where a.enabled = 1";
		authList = authoritiesDaoImpl.queryForList(hql, String.class);
		return authList;
	}
	
	public List<String> getResourceByAuthName(String authName){
		List<String> authList = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		sb = sb.append(" select a.resource_url from auth_resource a, authorities c ");
		sb = sb.append(" where a.id = c.auth_id and ");
		sb = sb.append(" c.auth_name = ? ");
		authList = authoritiesDaoImpl.sqlQueryForList(sb.toString(), String.class, authName);
		return authList;
	}

	@Override
	public List<String> getMethodByAuthName(String authName) {
		// TODO Auto-generated method stub
		return Collections.emptyList();
	}
	

}
