package com.vteba.home.index.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.home.index.model.Banner;
import com.vteba.home.index.service.spi.BannerService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BaseAction;

/**
 * 首页Banner控制器
 * @author yinlei
 * @date 2013年10月5日 下午6:45:11
 */
@Controller
@RequestMapping("/banner")
public class BannerAction extends BaseAction<Banner> {
	@Inject
	private BannerService bannerServiceImpl;
	
	/**
	 * 首页banner信息列表
	 * @param model 参数
	 * @return banner列表JSON字符串
	 * @author yinlei
	 * @date 2013年10月5日 下午6:52:06
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Banner> list(Banner model) {
		String hql = "select b from Banner b where b.state = 1 order by b.position asc";
		Page<Banner> page = new Page<Banner>();
		page.setPageSize(4);
		List<Banner> list = bannerServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Banner, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
