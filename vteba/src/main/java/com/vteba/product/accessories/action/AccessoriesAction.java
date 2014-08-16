package com.vteba.product.accessories.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.product.accessories.model.Accessories;
import com.vteba.product.accessories.service.spi.AccessoriesService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BasicAction;

/**
 * 配饰商品控制器
 * @author yinlei
 * @date 2013-10-8 20:14:44
 */
@Controller
@RequestMapping("/accessories")
public class AccessoriesAction extends BasicAction<Accessories> {
	@Inject
	private AccessoriesService accessoriesServiceImpl;
	
	/**
	 * 获得配饰商品List
	 * @param model 参数
	 * @return 配饰商品List JSON字符串
	 * @author yinlei
	 * @date 2013-10-8 20:14:44
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Accessories> list(Accessories model) {
		String hql = "select g from Accessories g ";
		Page<Accessories> page = new Page<Accessories>();
		page.setPageSize(10);
		List<Accessories> list = accessoriesServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Accessories, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
