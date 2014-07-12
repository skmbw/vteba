package com.vteba.shop.account.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.BaseServiceImpl;
import com.vteba.tx.hibernate.BaseGenericDao;
import com.vteba.shop.account.dao.spi.ConsumeDetailDao;
import com.vteba.shop.account.model.ConsumeDetail;
import com.vteba.shop.account.model.ConsumeDetailId;
import com.vteba.shop.account.service.spi.ConsumeDetailService;

/**
 * 用户账户消费明细Service实现。
 * @author yinlei
 * date 2013-8-31 21:09:01
 */
@Named
public class ConsumeDetailServiceImpl extends BaseServiceImpl<ConsumeDetail, ConsumeDetailId> implements ConsumeDetailService {
	private ConsumeDetailDao consumeDetailDaoImpl;
	
	@Inject
	@Override
	public void setBaseGenericDaoImpl(
			BaseGenericDao<ConsumeDetail, ConsumeDetailId> consumeDetailDaoImpl) {
		this.baseGenericDaoImpl = consumeDetailDaoImpl;
		this.consumeDetailDaoImpl = (ConsumeDetailDao) consumeDetailDaoImpl;
		
	}

	/**
	 * @return the consumeDetailDaoImpl
	 */
	public ConsumeDetailDao getConsumeDetailDaoImpl() {
		return consumeDetailDaoImpl;
	}

}
