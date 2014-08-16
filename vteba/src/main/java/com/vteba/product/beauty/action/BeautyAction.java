package com.vteba.product.beauty.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.product.beauty.model.Beauty;
import com.vteba.product.beauty.service.spi.BeautyService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BasicAction;

/**
 * 美妆商品控制器
 * @author yinlei
 * @date 2013-10-8 20:15:37
 */
@Controller
@RequestMapping("/beauty")
public class BeautyAction extends BasicAction<Beauty> {
	@Inject
	private BeautyService beautyServiceImpl;
	
	/**
	 * 获得美妆商品List
	 * @param model 参数
	 * @return 美妆商品List JSON字符串
	 * @author yinlei
	 * @date 2013-10-8 20:15:37
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Beauty> list(Beauty model) {
		String hql = "select g from Beauty g ";
		Page<Beauty> page = new Page<Beauty>();
		page.setPageSize(10);
		List<Beauty> list = beautyServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Beauty, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
