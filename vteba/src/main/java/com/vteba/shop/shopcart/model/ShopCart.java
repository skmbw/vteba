package com.vteba.shop.shopcart.model;

import java.util.List;
import java.util.Map;

/**
 * 购物车。
 * @author yinlei
 * @date 2013-8-26 下午2:00:40
 */
public class ShopCart {
	
	private Double totalPrice;//总价格
	private Integer totalNumber;//商品数量
	private Map<String, List<Item>> itemMap;//物品分类
	private List<Item> itemList;//物品明细

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Map<String, List<Item>> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, List<Item>> itemMap) {
		this.itemMap = itemMap;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
}
