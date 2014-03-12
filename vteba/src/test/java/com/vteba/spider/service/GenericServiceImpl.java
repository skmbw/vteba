package com.vteba.spider.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vteba.spider.tx.impl.HibernateGenericDaoImpl;

/**
 * 通用泛型Service实现，供其他Service继承，简化service实现。
 * @author yinlei 
 * date 2012-6-29 下午11:28:32
 */
@Transactional
public abstract class GenericServiceImpl<T, ID extends Serializable> {

	protected HibernateGenericDaoImpl<T, ID> hibernateGenericDaoImpl;
	
	/**
	 * 延迟到子类中注入具体dao实例
	 * @param hibernateGenericDaoImpl 实现HibernateGenericDaoImpl具体的dao实例
	 * @author yinlei
	 * date 2012-6-22 下午4:04:41
	 */
	public abstract void setHibernateGenericDaoImpl(HibernateGenericDaoImpl<T, ID> hibernateGenericDaoImpl);
	
	public ID save(T entity) {
		return hibernateGenericDaoImpl.save(entity);
	}

	public void persist(T entity) {
		hibernateGenericDaoImpl.persist(entity);
	}

	public List<T> getEntityListByHql(String hql, Object... values) {
		return hibernateGenericDaoImpl.getEntityListByHql(hql, values);
	}

	public void saveOrUpdate(T entity) {
		hibernateGenericDaoImpl.saveOrUpdate(entity);
	}

	public void update(T entity) {
		hibernateGenericDaoImpl.update(entity);
	}

	public T merge(T entity) {
		return hibernateGenericDaoImpl.merge(entity);
	}

	public T load(Class<T> entity, ID id) {
		return hibernateGenericDaoImpl.load(entity, id);
	}

	public T load(ID id) {
		return hibernateGenericDaoImpl.load(id);
	}

	public <X> X get(Class<X> entity, ID id) {
		return hibernateGenericDaoImpl.get(entity, id);
	}

	public T get(ID id) {
		return hibernateGenericDaoImpl.get(id);
	}

	public void delete(ID id) {
		hibernateGenericDaoImpl.delete(id);
	}

	public void delete(T entity) {
		hibernateGenericDaoImpl.delete(entity);
	}

	public <X> List<X> getAll(Class<X> entityClass) {
		return hibernateGenericDaoImpl.getAll(entityClass);
	}
	
	public List<Object[]> sqlQueryForObject(String sql, Object... values) {
		return hibernateGenericDaoImpl.sqlQueryForObject(sql, values);
	}

	public List<Object[]> hqlQueryForObject(String hql, boolean namedQuery,
			Object... values) {
		return hibernateGenericDaoImpl.hqlQueryForObject(hql, namedQuery,
				values);
	}

	public int executeHqlUpdate(String hql, boolean namedQuery, Object... values) {
		return hibernateGenericDaoImpl.executeHqlUpdate(hql, namedQuery, values);
	}

	public int executeSqlUpdate(String sql, Object... values) {
		return hibernateGenericDaoImpl.executeSqlUpdate(sql, values);
	}

	public void saveEntityBatch(List<T> list, int batchSize) {
		for (int i = 0; i< list.size(); i++) {
			T entity = list.get(i);
			persist(entity);
			if (i != 0 && i % batchSize == 0) {
				hibernateGenericDaoImpl.flush();
			}
		}
	}
	
	public void deleteEntityBatch(List<ID> list) {
		for (ID id : list) {
			delete(id);
		}
	}
	
}
