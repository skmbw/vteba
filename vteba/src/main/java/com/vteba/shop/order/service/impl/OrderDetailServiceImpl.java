package com.vteba.shop.order.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.shop.order.dao.spi.OrderDetailDao;
import com.vteba.shop.order.model.OrderDetail;
import com.vteba.shop.order.service.spi.OrderDetailService;

/**
 * 订单明细Service实现。
 * @author yinlei
 * date 2013-8-31 21:05:03
 */
@Named
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail, Long> implements OrderDetailService {
	private OrderDetailDao orderDetailDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<OrderDetail, Long> orderDetailDaoImpl) {
		this.baseGenericDaoImpl = orderDetailDaoImpl;
		this.orderDetailDaoImpl = (OrderDetailDao) orderDetailDaoImpl;
		
	}

	/**
	 * @return the orderDetailDaoImpl
	 */
	public OrderDetailDao getOrderDetailDaoImpl() {
		return orderDetailDaoImpl;
	}

}
