package com.vteba.community.collocation.dao.spi;

import com.vteba.tx.hibernate.IHibernateGenericDao;
import com.vteba.community.collocation.model.Collocation;

/**
 * 搭配推荐商品Dao接口。
 * @author yinlei
 * date 2013-10-5 17:10:30
 */
public interface CollocationDao extends IHibernateGenericDao<Collocation, Long> {

}
