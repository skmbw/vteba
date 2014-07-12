package com.vteba.community.collocation.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.vteba.community.collocation.model.Collocation;
import com.vteba.community.collocation.service.spi.CollocationService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BaseAction;

/**
 * 搭配推荐商品控制器
 * @author yinlei
 * @date 2013年10月5日 下午5:12:31
 */
@Controller
@RequestMapping("/collocation")
public class CollocationAction extends BaseAction<Collocation> {
	@Inject
	private CollocationService collocationServiceImpl;
	
	/**
	 * 获取推荐搭配商品列表
	 * @param model 参数
	 * @return 搭配List JSON字符串
	 * @author yinlei
	 * @date 2013年10月5日 下午5:15:03
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Collocation> list(Collocation model) {
		List<Collocation> list = Lists.newArrayList();
		String hql = "select c from Collocation c where c.state = 1 order by c.itemType asc";
		Page<Collocation> page = new Page<Collocation>();
		page.setPageSize(10);
		list = collocationServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Collocation, ? extends Serializable> baseServiceImpl) {
		// TODO Auto-generated method stub
		
	}

}
