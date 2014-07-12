package com.vteba.community.collocation.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.community.collocation.model.CollocationTag;
import com.vteba.community.collocation.service.spi.CollocationTagService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BaseAction;

/**
 * 搭配标签控制器
 * @author yinlei
 * @date 2013-10-8 16:59:39
 */
@Controller
@RequestMapping("/collocationTag")
public class CollocationTagAction extends BaseAction<CollocationTag> {
	@Inject
	private CollocationTagService collocationTagServiceImpl;
	
	/**
	 * 获得搭配标签List
	 * @param model 参数
	 * @return 搭配标签List JSON字符串
	 * @author yinlei
	 * @date 2013-10-8 16:59:39
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<CollocationTag> list(CollocationTag model) {
		String hql = "select g from CollocationTag g ";
		Page<CollocationTag> page = new Page<CollocationTag>();
		page.setPageSize(20);
		List<CollocationTag> list = collocationTagServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<CollocationTag, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
