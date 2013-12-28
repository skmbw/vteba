package com.vteba.product.shoes.service.spi;

import com.vteba.service.generic.IGenericService;
import com.vteba.product.shoes.model.Shoes;

/**
 * 鞋类商品service接口。
 * @author yinlei
 * date 2013-10-3 20:56:49
 */
public interface ShoesService extends IGenericService<Shoes, Long> {
	public Shoes test();
}
