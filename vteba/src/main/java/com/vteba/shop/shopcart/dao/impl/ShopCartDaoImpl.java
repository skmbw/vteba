package com.vteba.shop.shopcart.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.shop.shopcart.dao.spi.ShopCartDao;
import com.vteba.shop.shopcart.model.Item;
import com.vteba.tx.hibernate.impl.BaseGenericDaoImpl;

/**
 * 购物车Dao实现。
 * @author yinlei
 * date 2013-8-26 下午9:30:04
 */
@Named
public class ShopCartDaoImpl extends BaseGenericDaoImpl<Item, Long> implements ShopCartDao {

	public ShopCartDaoImpl() {
		super();
	}

	public ShopCartDaoImpl(Class<Item> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
	}


	
}
