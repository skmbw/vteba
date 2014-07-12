package com.vteba.community.group.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.community.group.dao.spi.GroupDao;
import com.vteba.community.group.model.Group;
import com.vteba.community.group.service.spi.GroupService;

/**
 * 社区小组Service实现。
 * @author yinlei
 * date 2013-10-7 22:22:54
 */
@Named
public class GroupServiceImpl extends BaseServiceImpl<Group, Long> implements GroupService {
	private GroupDao groupDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Group, Long> groupDaoImpl) {
		this.baseGenericDaoImpl = groupDaoImpl;
		this.groupDaoImpl = (GroupDao) groupDaoImpl;
		
	}

	/**
	 * @return the groupDaoImpl
	 */
	public GroupDao getGroupDaoImpl() {
		return groupDaoImpl;
	}

}
