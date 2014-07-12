package com.vteba.spider.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vteba.spider.model.Inventory;
import com.vteba.tx.hibernate.impl.HibernateGenericDaoImpl;

@Repository
public class InventoryDao extends HibernateGenericDaoImpl<Inventory, String> {

	@Autowired
	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
