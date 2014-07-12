package com.vteba.shop.account.dao.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;

import com.vteba.tx.hibernate.impl.BaseGenericDaoImpl;
import com.vteba.shop.account.dao.spi.AccountDao;
import com.vteba.shop.account.model.Account;

/**
 * 用户账户信息Dao实现。
 * @author yinlei
 * date 2013-8-31 21:08:12
 */
@Named
public class AccountDaoImpl extends BaseGenericDaoImpl<Account, Long> implements AccountDao {
	
	public AccountDaoImpl() {
		super();
	}

	public AccountDaoImpl(Class<Account> entityClass) {
		super(entityClass);
	}

	@Inject
	@Override
	public void setSessionFactory(SessionFactory skmbwSessionFactory) {
		this.sessionFactory = skmbwSessionFactory;
		
	}

}
