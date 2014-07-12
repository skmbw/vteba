package com.vteba.product.base.service.spi;

import java.util.Map;

import com.vteba.service.generic.BaseService;
import com.vteba.product.base.model.Tags;

/**
 * 商品标签service接口。
 * @author yinlei
 * date 2013-10-4 17:53:44
 */
public interface TagsService extends BaseService<Tags, Integer> {
	
	/**
	 * 根据一级标签ID获取标签树，一级标签一个，二级四个，三级由Map参数指定
	 * @param tags 参数
	 * @param countMap 各个三级标签的个数，如：[1,8][2,6][3,6][4,5]
	 * @return 标签树
	 * @author yinlei
	 * @date 2013年10月4日 下午10:38:07
	 */
	public Tags queryTagsTreeById(Tags tags, Map<Integer, Integer> countMap);
}
