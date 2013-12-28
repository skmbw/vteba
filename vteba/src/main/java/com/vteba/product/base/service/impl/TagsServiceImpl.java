package com.vteba.product.base.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.product.base.dao.spi.TagsDao;
import com.vteba.product.base.model.Tags;
import com.vteba.product.base.service.spi.TagsService;
import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tm.generic.Page;
import com.vteba.tm.hibernate.IHibernateGenericDao;

/**
 * 商品标签Service实现。
 * @author yinlei
 * date 2013-10-4 17:53:44
 */
@Named
public class TagsServiceImpl extends GenericServiceImpl<Tags, Integer> implements TagsService {
	private TagsDao tagsDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Tags, Integer> tagsDaoImpl) {
		this.hibernateGenericDaoImpl = tagsDaoImpl;
		this.tagsDaoImpl = (TagsDao) tagsDaoImpl;
		
	}

	/**
	 * @return the tagsDaoImpl
	 */
	public TagsDao getTagsDaoImpl() {
		return tagsDaoImpl;
	}

	public Tags queryTagsTreeById(Tags tags, Map<Integer, Integer> countMap) {
		//一级标签
		Tags pTags = tagsDaoImpl.get(tags.getTagsId());
		
		//二级标签
		String hql = "select t from Tags t where t.parentTags = ?1 and t.state = 1";
		Page<Tags> page = new Page<Tags>();
		page.setPageSize(4);
		List<Tags> tagsList = tagsDaoImpl.pagedQueryByHql(page, hql, tags);//t.parentTags是个实体，所以要传实体
		pTags.setChildTags(tagsList);
		
		//三级标签
		int i = 1;
		for (Tags t : tagsList) {
			page.setPageSize(countMap.get(i++));//三级标签每个获取的数量不一致，需要单独指定
			List<Tags> aTags = tagsDaoImpl.pagedQueryByHql(page, hql, t);
			t.setChildTags(aTags);
		}
		
		return pTags;
	}
}
