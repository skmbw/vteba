package com.vteba.shop.order.dao.spi;

import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.shop.order.model.Order;

/**
 * 订单Dao接口。
 * @author yinlei
 * date 2013-8-31 21:04:16
 */
public interface OrderDao extends BaseGenericDao<Order, Long> {

}
