package com.vteba.community.album.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.community.base.model.Daren;
import com.vteba.community.base.service.spi.DarenService;
import com.vteba.service.generic.IGenericService;
import com.vteba.tx.generic.Page;
import com.vteba.utils.ofbiz.LangUtils;
import com.vteba.web.action.BaseAction;

/**
 * 专辑达人控制器
 * @author yinlei
 * @date 2013年10月7日 下午3:48:57
 */
@Controller
@RequestMapping("/albumDaren")
public class AlbumDarenAction extends BaseAction<Daren> {
	@Inject
	private DarenService darenServiceImpl;
	
	/**
	 * 专辑达人列表。
	 * @param model 参数
	 * @return 达人List JSON字符串
	 * @author yinlei
	 * @date 2013年10月7日 下午3:50:44
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Daren> list(Daren model) {
		//String hql = "select b from Daren b where b.enable = 1 and b.darenType = 2";
		Page<Daren> page = new Page<Daren>();
		page.setPageSize(6);
		List<Daren> list = darenServiceImpl.pagedQueryList(page, LangUtils.toMap("enable", 1, "darenType", 2));
		return list;
	}

	@Override
	public void setGenericServiceImpl(
			IGenericService<Daren, ? extends Serializable> genericServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
