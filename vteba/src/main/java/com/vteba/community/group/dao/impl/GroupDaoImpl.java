package com.vteba.community.group.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.BaseGenericDaoImpl;
import com.vteba.community.group.dao.spi.GroupDao;
import com.vteba.community.group.model.Group;

/**
 * 社区小组Dao实现。
 * @author yinlei
 * date 2013-10-7 22:22:54
 */
@Named
public class GroupDaoImpl extends BaseGenericDaoImpl<Group, Long> implements GroupDao {
	
	public GroupDaoImpl() {
		super();
	}

	public GroupDaoImpl(Class<Group> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
