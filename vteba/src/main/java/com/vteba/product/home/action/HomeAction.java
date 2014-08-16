package com.vteba.product.home.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.product.home.model.Home;
import com.vteba.product.home.service.spi.HomeService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BasicAction;

/**
 * 家居商品控制器
 * @author yinlei
 * @date 2013-10-8 20:16:35
 */
@Controller
@RequestMapping("/home")
public class HomeAction extends BasicAction<Home> {
	@Inject
	private HomeService homeServiceImpl;
	
	/**
	 * 获得家居商品List
	 * @param model 参数
	 * @return 家居商品List JSON字符串
	 * @author yinlei
	 * @date 2013-10-8 20:16:35
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Home> list(Home model) {
		String hql = "select g from Home g ";
		Page<Home> page = new Page<Home>();
		page.setPageSize(10);
		List<Home> list = homeServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Home, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
