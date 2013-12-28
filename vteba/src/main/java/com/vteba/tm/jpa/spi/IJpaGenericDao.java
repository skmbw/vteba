package com.vteba.tm.jpa.spi;

import java.io.Serializable;

import com.vteba.tm.generic.IGenericDao;

public interface IJpaGenericDao<T, ID extends Serializable> extends IGenericDao<T, ID> {
	/**
	 * 保存实体entity，立即持久化，session.save(entity)
	 * @param entity
	 * @return 实体主键
	 */
	public ID save(T entity);
	/**
	 * 持久化实体，session.persist(entity)，尽可能延迟到事务结束
	 * @param entity
	 */
	public void persist(T entity);
	/**
	 * 保存或更新实体entity，session.saveOrUpdate(entity)
	 * @param entity
	 */
	public void saveOrUpdate(T entity);
	/**
	 * 更新实体entity，session.update(entity)
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * 合并实体entity，session.merge(entity)，同JPA merge()
	 * @param entity 实体
	 * @return 实体
	 */
	public T merge(T entity);
	/**
	 * 根据ID load指定entity实体，总尝试返回代理，为空时抛出异常，同JPA getReference()
	 * @param entity 实体类型
	 * @param id 主键
	 * @return 实体
	 */
	public T load(Class<T> entity, ID id);
	/**
	 * 根据ID load实体，总尝试返回代理，为空时抛出异常，session.load(entityClass, id, lockMode)
	 * @param id 实体主键
	 * @return 实体
	 */
	public T load(ID id);
	/**
	 * 根据ID get指定entity实体，立即命中数据库，为空时返回null，同JPA find()
	 * @param entity
	 * @param id 主键
	 * @return 实体
	 */
	public <X> X get(Class<X> entity, ID id);
	/**
	 * 根据ID get实体，立即命中数据库，为空时返回null，同JPA find()
	 * @param id 主键
	 * @return 实体
	 */
	public T get(ID id);
	
	/**
	 * 根据ID删除实体
	 * @param id
	 */
	public void deleteById(ID id);
	/**
	 * 根据entity删除实体，同JPA remove()
	 * @param entity
	 */
	public void delete(T entity);
}
