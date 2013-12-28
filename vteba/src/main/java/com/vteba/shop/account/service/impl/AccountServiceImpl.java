package com.vteba.shop.account.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.vteba.service.generic.impl.GenericServiceImpl;
import com.vteba.tm.hibernate.IHibernateGenericDao;
import com.vteba.shop.account.dao.spi.AccountDao;
import com.vteba.shop.account.model.Account;
import com.vteba.shop.account.service.spi.AccountService;

/**
 * 用户账户信息Service实现。
 * @author yinlei
 * date 2013-8-31 21:08:12
 */
@Named
public class AccountServiceImpl extends GenericServiceImpl<Account, Long> implements AccountService {
	private AccountDao accountDaoImpl;
	
	@Inject
	@Override
	public void setHibernateGenericDaoImpl(
			IHibernateGenericDao<Account, Long> accountDaoImpl) {
		this.hibernateGenericDaoImpl = accountDaoImpl;
		this.accountDaoImpl = (AccountDao) accountDaoImpl;
		
	}

	/**
	 * @return the accountDaoImpl
	 */
	public AccountDao getAccountDaoImpl() {
		return accountDaoImpl;
	}

}
