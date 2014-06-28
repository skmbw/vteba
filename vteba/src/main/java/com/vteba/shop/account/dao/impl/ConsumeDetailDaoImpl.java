package com.vteba.shop.account.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.shop.account.dao.spi.ConsumeDetailDao;
import com.vteba.shop.account.model.ConsumeDetail;
import com.vteba.shop.account.model.ConsumeDetailId;

/**
 * 用户账户消费明细Dao实现。
 * @author yinlei
 * date 2013-8-31 21:09:01
 */
@Named
public class ConsumeDetailDaoImpl extends HibernateGenericDaoImpl<ConsumeDetail, ConsumeDetailId> implements ConsumeDetailDao {
	
	public ConsumeDetailDaoImpl() {
		super();
	}

	public ConsumeDetailDaoImpl(Class<ConsumeDetail> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
