package com.vteba.shop.order.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;
import com.vteba.shop.order.dao.spi.OrderDao;
import com.vteba.shop.order.model.Order;

/**
 * 订单Dao实现。
 * @author yinlei
 * date 2013-8-31 21:04:16
 */
@Named
public class OrderDaoImpl extends HibernateGenericDaoImpl<Order, Long> implements OrderDao {
	
	public OrderDaoImpl() {
		super();
	}

	public OrderDaoImpl(Class<Order> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
