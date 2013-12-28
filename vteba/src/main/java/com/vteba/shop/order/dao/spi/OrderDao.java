package com.vteba.shop.order.dao.spi;

import com.vteba.tm.hibernate.IHibernateGenericDao;
import com.vteba.shop.order.model.Order;

/**
 * 订单Dao接口。
 * @author yinlei
 * date 2013-8-31 21:04:16
 */
public interface OrderDao extends IHibernateGenericDao<Order, Long> {

}
