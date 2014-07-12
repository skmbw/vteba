package com.vteba.spider.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vteba.spider.tx.IHibernateGenericDao;

/**
 * 通用泛型Service实现，供其他Service继承，简化service实现。
 * @author yinlei 
 * date 2012-6-29 下午11:28:32
 */
@Transactional
public abstract class GenericServiceImpl<T, ID extends Serializable> {

	protected IHibernateGenericDao<T, ID> BaseGenericDaoImpl;
	
	/**
	 * 延迟到子类中注入具体dao实例
	 * @param BaseGenericDaoImpl 实现BaseGenericDaoImpl具体的dao实例
	 * @author yinlei
	 * date 2012-6-22 下午4:04:41
	 */
	public abstract void setBaseGenericDaoImpl(IHibernateGenericDao<T, ID> BaseGenericDaoImpl);
	
	public ID save(T entity) {
		return BaseGenericDaoImpl.save(entity);
	}

	public void persist(T entity) {
		BaseGenericDaoImpl.persist(entity);
	}

	public List<T> getEntityListByHql(String hql, Object... values) {
		return BaseGenericDaoImpl.getEntityListByHql(hql, values);
	}

	public void saveOrUpdate(T entity) {
		BaseGenericDaoImpl.saveOrUpdate(entity);
	}

	public void update(T entity) {
		BaseGenericDaoImpl.update(entity);
	}

	public T merge(T entity) {
		return BaseGenericDaoImpl.merge(entity);
	}

	public T load(Class<T> entity, ID id) {
		return BaseGenericDaoImpl.load(entity, id);
	}

	public T load(ID id) {
		return BaseGenericDaoImpl.load(id);
	}

	public <X> X get(Class<X> entity, ID id) {
		return BaseGenericDaoImpl.get(entity, id);
	}

	public T get(ID id) {
		return BaseGenericDaoImpl.get(id);
	}

	public void delete(ID id) {
		BaseGenericDaoImpl.delete(id);
	}

	public void delete(T entity) {
		BaseGenericDaoImpl.delete(entity);
	}

	public <X> List<X> getAll(Class<X> entityClass) {
		return BaseGenericDaoImpl.getAll(entityClass);
	}
	
	public List<Object[]> sqlQueryForObject(String sql, Object... values) {
		return BaseGenericDaoImpl.sqlQueryForObject(sql, values);
	}

	public List<Object[]> hqlQueryForObject(String hql, boolean namedQuery,
			Object... values) {
		return BaseGenericDaoImpl.hqlQueryForObject(hql, namedQuery,
				values);
	}

	public int executeHqlUpdate(String hql, boolean namedQuery, Object... values) {
		return BaseGenericDaoImpl.executeHqlUpdate(hql, namedQuery, values);
	}

	public int executeSqlUpdate(String sql, Object... values) {
		return BaseGenericDaoImpl.executeSqlUpdate(sql, values);
	}

	public void saveEntityBatch(List<T> list, int batchSize) {
		for (int i = 0; i< list.size(); i++) {
			T entity = list.get(i);
			persist(entity);
			if (i != 0 && i % batchSize == 0) {
				BaseGenericDaoImpl.flush();
			}
		}
	}
	
	public void deleteEntityBatch(List<ID> list) {
		for (ID id : list) {
			delete(id);
		}
	}
	
}
