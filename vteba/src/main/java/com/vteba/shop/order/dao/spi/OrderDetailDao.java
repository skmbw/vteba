package com.vteba.shop.order.dao.spi;

import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.shop.order.model.OrderDetail;

/**
 * 订单明细Dao接口。
 * @author yinlei
 * date 2013-8-31 21:05:03
 */
public interface OrderDetailDao extends IHibernateGenericDao<OrderDetail, Long> {

}
