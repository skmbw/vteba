package com.vteba.community.group.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.community.group.dao.spi.GroupDao;
import com.vteba.community.group.model.Group;
import com.vteba.community.group.service.spi.GroupService;

/**
 * 社区小组Service实现。
 * @author yinlei
 * date 2013-10-7 22:22:54
 */
@Named
public class GroupServiceImpl extends GenericServiceImpl<Group, Long> implements GroupService {
	private GroupDao groupDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Group, Long> groupDaoImpl) {
		this.hibernateGenericDaoImpl = groupDaoImpl;
		this.groupDaoImpl = (GroupDao) groupDaoImpl;
		
	}

	/**
	 * @return the groupDaoImpl
	 */
	public GroupDao getGroupDaoImpl() {
		return groupDaoImpl;
	}

}
