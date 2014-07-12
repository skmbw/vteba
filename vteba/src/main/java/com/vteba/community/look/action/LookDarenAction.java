package com.vteba.community.look.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.community.base.model.Daren;
import com.vteba.community.base.service.spi.DarenService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BaseAction;

/**
 * 晒货达人控制器
 * @author yinlei
 * @date 2013年10月5日 下午10:09:49
 */
@Controller
@RequestMapping("/lookDaren")
public class LookDarenAction extends BaseAction<Daren> {
	@Inject
	private DarenService darenServiceImpl;
	
	/**
	 * 晒货达人列表。
	 * @param model 参数
	 * @return 达人List JSON字符串
	 * @author yinlei
	 * @date 2013年10月7日 下午3:21:44
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Daren> list(Daren model) {
		String hql = "select b from Daren b where b.enable = 1 and b.darenType = 1";
		Page<Daren> page = new Page<Daren>();
		page.setPageSize(6);
		List<Daren> list = darenServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Daren, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
