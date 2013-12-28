package com.vteba.user.dao.impl;

import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * User Mongodb操作扩展，内部接口，实现。
 * @author yinlei
 * @date 2013年10月19日 下午10:36:30
 */
//@Named
public class MongoUserRepoImpl {//extends MongoGenericDaoImpl<User, Long> implements MongoUserRepo {
	
	//@Inject
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		//this.mongoTemplate = mongoTemplate;
	}
	
}
