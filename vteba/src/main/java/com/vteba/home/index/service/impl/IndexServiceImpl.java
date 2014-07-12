package com.vteba.home.index.service.impl;

import javax.inject.Named;

import com.vteba.common.model.AstModel;
import com.vteba.home.index.service.IndexService;
import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;

/**
 * 首页Service实现类，添加此类的目的是缓存首页需要的数据。加快响应速度。
 * @author yinlei
 * date 2013-8-23 下午9:42:21
 */
@Named
public class IndexServiceImpl extends BaseServiceImpl<AstModel, String> implements IndexService {

	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<AstModel, String> BaseGenericDaoImpl) {
		
	}

}
