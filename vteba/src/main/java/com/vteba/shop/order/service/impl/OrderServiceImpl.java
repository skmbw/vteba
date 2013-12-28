package com.vteba.shop.order.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tm.hibernate.IHibernateGenericDao;
import com.vteba.shop.order.dao.spi.OrderDao;
import com.vteba.shop.order.model.Order;
import com.vteba.shop.order.service.spi.OrderService;

/**
 * 订单Service实现。
 * @author yinlei
 * date 2013-8-31 21:04:16
 */
@Named
public class OrderServiceImpl extends GenericServiceImpl<Order, Long> implements OrderService {
	private OrderDao orderDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Order, Long> orderDaoImpl) {
		this.hibernateGenericDaoImpl = orderDaoImpl;
		this.orderDaoImpl = (OrderDao) orderDaoImpl;
		
	}

	/**
	 * @return the orderDaoImpl
	 */
	public OrderDao getOrderDaoImpl() {
		return orderDaoImpl;
	}

}
