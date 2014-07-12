package com.vteba.community.group.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Lists;
import com.vteba.community.group.model.Group;
import com.vteba.community.group.service.spi.GroupService;
import com.vteba.service.generic.BaseService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BaseAction;

/**
 * 社区小组控制器
 * @author yinlei
 * @date 2013年10月7日 下午10:25:24
 */
@Controller
@RequestMapping("/group")
public class GroupAction extends BaseAction<Group> {
	@Inject
	private GroupService groupServiceImpl;
	
	/**
	 * 小组list
	 * @param model 参数
	 * @return 小组List JSON字符串
	 * @author yinlei
	 * @date 2013年10月7日 下午10:27:07
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<Group> list(Group model) {
		List<Group> list = Lists.newArrayList();
		String hql = "select g from Group g where g.category in (1,2,3,4) order by g.category asc";
		Page<Group> page = new Page<Group>();
		page.setPageSize(14);
		list = groupServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setBaseServiceImpl(
			BaseService<Group, ? extends Serializable> BaseServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
