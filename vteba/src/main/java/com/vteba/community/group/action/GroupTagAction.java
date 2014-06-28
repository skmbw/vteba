package com.vteba.community.group.action;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vteba.community.group.model.GroupTag;
import com.vteba.community.group.service.spi.GroupTagService;
import com.vteba.service.generic.IGenericService;
import com.vteba.tx.generic.Page;
import com.vteba.web.action.BaseAction;

/**
 * 小组标签控制器
 * @author yinlei
 * @date 2013年10月8日 下午4:27:56
 */
@Controller
@RequestMapping("/groupTag")
public class GroupTagAction extends BaseAction<GroupTag> {
	@Inject
	private GroupTagService groupTagServiceImpl;
	
	/**
	 * 获得小组标签List
	 * @param model 参数
	 * @return 小组标签List JSON字符串
	 * @author yinlei
	 * @date 2013年10月8日 下午4:33:13
	 */
	@ResponseBody
	@RequestMapping("/list")
	public List<GroupTag> list(GroupTag model) {
		String hql = "select g from GroupTag g where g.state = 1";
		Page<GroupTag> page = new Page<GroupTag>();
		page.setPageSize(10);
		List<GroupTag> list = groupTagServiceImpl.pagedQueryByHql(page, hql);
		return list;
	}

	@Override
	public void setGenericServiceImpl(
			IGenericService<GroupTag, ? extends Serializable> genericServiceImpl) {
		// TODO Auto-generated method stub
		
	}
}
