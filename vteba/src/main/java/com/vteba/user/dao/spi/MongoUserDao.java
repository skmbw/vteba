package com.vteba.user.dao.spi;

import com.vteba.ext.mongodb.spi.MongoGenericDao;
import com.vteba.user.model.User;

/**
 * Mongodb User Dao接口，Spring自动装配来装配，无需实现。
 * @author yinlei
 * @date 2013年10月19日 下午10:37:24
 */
public interface MongoUserDao extends MongoGenericDao<User, Long> {

}
