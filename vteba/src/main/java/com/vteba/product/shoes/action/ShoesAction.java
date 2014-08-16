package com.vteba.product.shoes.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.product.shoes.model.Shoes;
import com.vteba.product.shoes.service.spi.ShoesService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BasicAction;

/**
 * 鞋子类商品控制器。
 * @author yinlei
 * @date 2013年10月3日 下午8:46:07
 */
@Controller
@RequestMapping("/shoes")
public class ShoesAction extends BasicAction<Shoes> {
	@Inject
	private ShoesService shoesServiceImpl;
	
	/**
	 * 鞋类商品，首页列表
	 * @param model 参数
	 * @return 鞋类列表JSON字符串
	 * @author yinlei
	 * @date 2013年10月5日 下午2:51:27
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Shoes> list(Shoes model) {
		shoesServiceImpl.test();
		String hql = "select s from Shoes s";
		Page<Shoes> page = new Page<Shoes>();
		page.setPageSize(6);
		List<Shoes> list = shoesServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Shoes, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
