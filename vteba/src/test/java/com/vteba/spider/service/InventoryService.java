package com.vteba.spider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vteba.spider.dao.InventoryDao;
import com.vteba.spider.model.Inventory;
import com.vteba.spider.tx.IHibernateGenericDao;

@Transactional
@Service
public class InventoryService extends GenericServiceImpl<Inventory, String> {
	
	protected InventoryDao inventoryDao;

	@Autowired
	@Override
	public void setBaseGenericDaoImpl(
			IHibernateGenericDao<Inventory, String> BaseGenericDaoImpl) {
		this.BaseGenericDaoImpl = BaseGenericDaoImpl;
		this.inventoryDao = (InventoryDao) BaseGenericDaoImpl;
	}
	
	
}
