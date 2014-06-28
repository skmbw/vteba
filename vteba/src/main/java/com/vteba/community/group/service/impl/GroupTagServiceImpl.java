package com.vteba.community.group.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.community.group.dao.spi.GroupTagDao;
import com.vteba.community.group.model.GroupTag;
import com.vteba.community.group.service.spi.GroupTagService;

/**
 * 小组标签Service实现。
 * @author yinlei
 * date 2013-10-8 15:23:29
 */
@Named
public class GroupTagServiceImpl extends GenericServiceImpl<GroupTag, Integer> implements GroupTagService {
	private GroupTagDao groupTagDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<GroupTag, Integer> groupTagDaoImpl) {
		this.hibernateGenericDaoImpl = groupTagDaoImpl;
		this.groupTagDaoImpl = (GroupTagDao) groupTagDaoImpl;
		
	}

	/**
	 * @return the groupTagDaoImpl
	 */
	public GroupTagDao getGroupTagDaoImpl() {
		return groupTagDaoImpl;
	}

}
