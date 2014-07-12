package com.vteba.shop.shopcart.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.shop.shopcart.dao.spi.ShopCartDao;
import com.vteba.shop.shopcart.model.Item;
import com.vteba.shop.shopcart.service.spi.ShopCartService;
import com.vteba.tx.hibernate.BaseGenericDao;

/**
 * 基于持久化的购物车服务实现。
 * @author yinlei
 * @date 2013-8-26 下午1:52:06
 */
@Named
public class ShopCartServiceImpl extends BaseServiceImpl<Item, Long> implements ShopCartService {
	
	private ShopCartDao shopCartDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<Item, Long> shopCartDaoImpl) {
		this.baseGenericDaoImpl = shopCartDaoImpl;
		this.shopCartDaoImpl = (ShopCartDao) shopCartDaoImpl;
	}
	
	@Override
	public boolean addItem(Item item) {
		this.shopCartDaoImpl.save(item);
		return true;
	}

	@Override
	public boolean addItemList(List<Item> itemList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateItem(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateItemList(List<Item> itemList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItem(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteItemList(List<Item> itemList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteAllItems(String cookieId) {
		// TODO Auto-generated method stub
		return false;
	}

}
