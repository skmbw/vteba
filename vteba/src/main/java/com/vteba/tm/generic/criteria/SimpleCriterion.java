package com.vteba.tm.generic.criteria;

public class SimpleCriterion implements Criterion {
	private String expression;
	private Object value;

	public SimpleCriterion() {
		super();
	}

	public SimpleCriterion(String expression) {
		super();
		this.expression = expression;
	}
	
	public SimpleCriterion(String expression, Object value) {
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

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return null;
	}
}
