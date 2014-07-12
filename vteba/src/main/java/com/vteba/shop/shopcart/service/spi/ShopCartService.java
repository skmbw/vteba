package com.vteba.shop.shopcart.service.spi;

import java.util.List;

import com.vteba.service.generic.BaseService;
import com.vteba.shop.shopcart.model.Item;

/**
 * 基于持久化的购物车服务。
 * @author yinlei
 * @date 2013-8-26 下午1:51:22
 */
public interface ShopCartService extends BaseService<Item, Long>{
	public boolean addItem(Item item);
	
	public boolean addItemList(List<Item> itemList);
	
	public int updateItem(Item item);
	
	public int updateItemList(List<Item> itemList);
	
	public int deleteItem(Item item);
	
	public int deleteItemList(List<Item> itemList);
	
	public boolean deleteAllItems(String cookieId);
}
