package com.vteba.shop.shopcart.dao.spi;

import com.vteba.shop.shopcart.model.Item;
import com.vteba.tx.hibernate.BaseGenericDao;

/**
 * 购物车Dao接口。
 * @author yinlei
 * date 2013-8-26 下午9:30:12
 */
public interface ShopCartDao extends BaseGenericDao<Item, Long> {
	
}
