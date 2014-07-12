package com.vteba.product.bag.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.product.bag.model.Bag;
import com.vteba.product.bag.service.spi.BagService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BaseAction;

/**
 * 包包商品控制器
 * @author yinlei
 * @date 2013-10-8 20:15:07
 */
@Controller
@RequestMapping("/bag")
public class BagAction extends BaseAction<Bag> {
	@Inject
	private BagService bagServiceImpl;
	
	/**
	 * 获得包包商品List
	 * @param model 参数
	 * @return 包包商品List JSON字符串
	 * @author yinlei
	 * @date 2013-10-8 20:15:07
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Bag> list(Bag model) {
		String hql = "select g from Bag g ";
		Page<Bag> page = new Page<Bag>();
		page.setPageSize(10);
		List<Bag> list = bagServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Bag, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
