package com.vteba.community.look.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.community.look.model.Look;
import com.vteba.community.look.service.spi.LookService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BasicAction;

/**
 * 晒货的商品控制器
 * @author yinlei
 * @date 2013年10月5日 下午10:10:13
 */
@Controller
@RequestMapping("/look")
public class LookAction extends BasicAction<Look> {
	@Inject
	private LookService lookServiceImpl;
	
	/**
	 * 获取用户晒货商品List
	 * @param model 参数
	 * @return 晒货商品List JSON字符串
	 * @author yinlei
	 * @date 2013年10月5日 下午10:27:13
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Look> list(Look model) {
		String hql = "select b from Look b where b.state = 1";
		Page<Look> page = new Page<Look>();
		page.setPageSize(18);
		List<Look> list = lookServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Look, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
