package com.vteba.home.index.action;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vteba.community.album.model.AlbumType;
import com.vteba.community.album.service.spi.AlbumTypeService;
import com.vteba.tm.generic.Page;
import com.vteba.web.action.BaseAction;

/**
 * 首页控制器。
 * @author yinlei
 * date 2013-8-20 下午9:09:49
 */
@Controller
public class IndexActionn extends BaseAction {
	@Inject
	private AlbumTypeService albumTypeServiceImpl;
	
	/**
	 * 初始化首页数据，为保证响应速度，数据需要缓存。
	 * @param request
	 * @param response
	 * @return 跳转到首页/jsp/index.jsp
	 * @author yinlei
	 * date 2013-8-20 下午9:11:51
	 */
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Map<String, Object> map) {
		String hql = "select a from AlbumType a";
		
		Page<AlbumType> page = new Page<AlbumType>();
		page.setPageSize(4);
		List<AlbumType> list = albumTypeServiceImpl.pagedQueryByHql(page, hql);
		
		map.put("albumTypeList", list);
		return "index";
	}
}
