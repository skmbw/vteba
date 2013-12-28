package com.vteba.community.group.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.community.group.dao.spi.GroupTagDao;
import com.vteba.community.group.model.GroupTag;

/**
 * 小组标签Dao实现。
 * @author yinlei
 * date 2013-10-8 15:23:29
 */
@Named
public class GroupTagDaoImpl extends HibernateGenericDaoImpl<GroupTag, Integer> implements GroupTagDao {
	
	public GroupTagDaoImpl() {
		super();
	}

	public GroupTagDaoImpl(Class<GroupTag> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
