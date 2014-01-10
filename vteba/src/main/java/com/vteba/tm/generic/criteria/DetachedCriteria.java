package com.vteba.tm.generic.criteria;

import java.util.ArrayList;
import java.util.List;

public class DetachedCriteria {
	private String clazzName;
	private List<Criterion> criterionList = new ArrayList<Criterion>();
	private boolean distinct;
	private List<String> orderBy = new ArrayList<String>();
	
	protected DetachedCriteria() {
		super();
	}
	
	protected DetachedCriteria(Class<?> clazz) {
		super();
		this.clazzName = clazz.getName();
	}
	
	public static DetachedCriteria forClass(Class<?> clazz) {
		return new DetachedCriteria(clazz);
	}
	
	public DetachedCriteria add(Criterion criterion) {
		criterionList.add(criterion);
		return this;
	}

	public DetachedCriteria and(Criterion criterion) {
		criterionList.add(criterion);
		return this;
	}
	
	public DetachedCriteria or(Criterion criterion) {
		criterionList.add(criterion);
		return this;
	}
	
	public DetachedCriteria orderBy(Order order) {
		orderBy.add(order.getOrderBy());
		return this;
	}
	
	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public List<Criterion> getCriterionList() {
		return criterionList;
	}

	public void setCriterionList(List<Criterion> criterionList) {
		this.criterionList = criterionList;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public List<String> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy.add(orderBy);
	}

	@Override
	public String toString() {
		return "DetachedCriteria [clazzName=" + clazzName + ", criterionList="
				+ criterionList + ", distinct=" + distinct + ", orderBy="
				+ orderBy + "]";
	}
	
}
