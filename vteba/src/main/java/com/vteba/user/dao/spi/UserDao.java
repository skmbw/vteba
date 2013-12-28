package com.vteba.user.dao.spi;

import com.vteba.tm.hibernate.IHibernateGenericDao;
import com.vteba.user.model.User;

/**
 * 用户Dao接口。
 * @author yinlei
 * date 2013-8-31 0:45:14
 */
public interface UserDao extends IHibernateGenericDao<User, Long> {

}
