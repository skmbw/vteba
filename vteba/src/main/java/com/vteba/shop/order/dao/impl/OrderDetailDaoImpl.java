package com.vteba.shop.order.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tm.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.shop.order.dao.spi.OrderDetailDao;
import com.vteba.shop.order.model.OrderDetail;

/**
 * 订单明细Dao实现。
 * @author yinlei
 * date 2013-8-31 21:05:03
 */
@Named
public class OrderDetailDaoImpl extends HibernateGenericDaoImpl<OrderDetail, Long> implements OrderDetailDao {
	
	public OrderDetailDaoImpl() {
		super();
	}

	public OrderDetailDaoImpl(Class<OrderDetail> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
