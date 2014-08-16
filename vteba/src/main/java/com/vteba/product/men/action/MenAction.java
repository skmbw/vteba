package com.vteba.product.men.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.product.men.model.Men;
import com.vteba.product.men.service.spi.MenService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BasicAction;

/**
 * 男装商品控制器
 * @author yinlei
 * @date 2013-10-8 20:16:55
 */
@Controller
@RequestMapping("/men")
public class MenAction extends BasicAction<Men> {
	@Inject
	private MenService menServiceImpl;
	
	/**
	 * 获得男装商品List
	 * @param model 参数
	 * @return 男装商品List JSON字符串
	 * @author yinlei
	 * @date 2013-10-8 20:16:55
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Men> list(Men model) {
		String hql = "select g from Men g ";
		Page<Men> page = new Page<Men>();
		page.setPageSize(10);
		List<Men> list = menServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Men, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
