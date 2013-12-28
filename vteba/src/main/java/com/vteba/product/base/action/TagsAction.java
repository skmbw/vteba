package com.vteba.product.base.action;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.vteba.product.base.model.Tags;
import com.vteba.product.base.service.spi.TagsService;
import com.vteba.web.action.BaseAction;

/**
 * 商品标签控制器
 * @author yinlei
 * @date 2013年10月4日 下午5:58:11
 */
@Controller
@RequestMapping("/tags")
public class TagsAction extends BaseAction {
	
	@Inject
	private TagsService tagsServiceImpl;
	
	/**
	 * 获取某一商品分类的标签。
	 * @param tags Tags
	 * @return 标签List
	 * @author yinlei
	 * @date 2013年10月4日 下午6:01:45
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Tags list(Tags tags) {
		//使用左外连接及时抓取，虽然可以，但是不够灵活，而且影响其他的查询，不使用
		//String hql = "select distinct t from Tags t left join fetch t.childTags where t.tagsId = ?1";
		Map<Integer, Integer> countMap = Maps.newHashMap();//这个要从配置参数中去取
		countMap.put(1, 10);
		countMap.put(2, 6);
		countMap.put(3, 6);
		countMap.put(4, 6);
		Tags pTags = tagsServiceImpl.queryTagsTreeById(tags, countMap);
		return pTags;
	}
}
