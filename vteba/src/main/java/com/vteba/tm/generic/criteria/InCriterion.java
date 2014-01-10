package com.vteba.tm.generic.criteria;

import java.util.List;

public class InCriterion implements Criterion {
	private String expression;
	private List<?> value;

	public InCriterion() {
		super();
	}

	public InCriterion(String expression, List<?> value) {
		super();
		this.expression = expression;
		this.value = value;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public List<?> getValue() {
		return value;
	}

	public void setValue(List<?> value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "InCriterion [expression=" + expression + ", value=" + value + "]";
	}
	
}
