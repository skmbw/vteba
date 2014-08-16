package com.vteba.community.album.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.vteba.community.album.model.Album;
import com.vteba.community.album.service.spi.AlbumService;
import com.vteba.service.generic.BaseService;
import com.vteba.web.action.BasicAction;

/**
 * 专辑控制器
 * @author yinlei
 * @date 2013年10月7日 下午4:43:13
 */
@Controller
@RequestMapping("/album")
public class AlbumAction extends BasicAction<Album> {
	@Inject
	private AlbumService albumServiceImpl;
	
	/**
	 * 首页专辑列表
	 * @param model 参数
	 * @return 专辑列表List JSON字符串
	 * @author yinlei
	 * @date 2013年10月7日 下午4:45:03
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Album> list(Album model) {
		List<Album> list = Lists.newArrayList();
		
		String hql = "select distinct a from Album a left join fetch a.imagesList";
		list = albumServiceImpl.getListByHql(hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Album, ? extends Serializable> baseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
