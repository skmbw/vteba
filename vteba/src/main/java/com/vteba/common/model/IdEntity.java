package com.vteba.common.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 实体ID公共策略。
 * @author yinlei
 * date 2013-9-15 下午1:39:10
 */
@MappedSuperclass
public abstract class IdEntity implements AstModel {

	private static final long serialVersionUID = 1L;
	protected Long id;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
