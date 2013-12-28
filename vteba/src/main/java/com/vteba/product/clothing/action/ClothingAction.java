package com.vteba.product.clothing.action;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.product.clothing.model.Clothing;
import com.vteba.product.clothing.service.spi.ClothingService;
import com.vteba.tm.generic.Page;
import com.vteba.web.action.BaseAction;

/**
 * 衣服类商品Action。
 * @author yinlei
 * @date 2013年10月3日 下午9:31:35
 */
@Controller
@RequestMapping("/clothing")
public class ClothingAction extends BaseAction {
	@Inject
	private ClothingService clothingServiceImpl;
	
	/**
	 * 首页衣服类商品列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Clothing> list(Clothing modelMap) {
		String hql = "select c from Clothing c";
		Page<Clothing> page = new Page<Clothing>();
		page.setPageSize(6);
		List<Clothing> list  = clothingServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}
}
