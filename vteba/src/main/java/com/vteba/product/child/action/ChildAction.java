package com.vteba.product.child.action;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.product.child.model.Child;
import com.vteba.product.child.service.spi.ChildService;
import com.vteba.tm.generic.Page;
import com.vteba.web.action.BaseAction;

/**
 * 亲子商品控制器
 * @author yinlei
 * @date 2013-10-8 20:16:05
 */
@Controller
@RequestMapping("/child")
public class ChildAction extends BaseAction {
	@Inject
	private ChildService childServiceImpl;
	
	/**
	 * 获得亲子商品List
	 * @param model 参数
	 * @return 亲子商品List JSON字符串
	 * @author yinlei
	 * @date 2013-10-8 20:16:05
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Child> list(Child model) {
		String hql = "select g from Child g ";
		Page<Child> page = new Page<Child>();
		page.setPageSize(10);
		List<Child> list = childServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}
}
