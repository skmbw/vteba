package com.vteba.tm.generic.criteria;

public class BetweenCriterion implements Criterion {
	private String expression;
	private Object lowValue;
	private Object highValue;

	public BetweenCriterion() {
		super();
	}

	public BetweenCriterion(String expression, Object lowValue, Object highValue) {
		super();
		this.expression = expression;
		this.lowValue = lowValue;
		this.highValue = highValue;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public Object getLowValue() {
		return lowValue;
	}

	public void setLowValue(Object lowValue) {
		this.lowValue = lowValue;
	}

	public Object getHighValue() {
		return highValue;
	}

	public void setHighValue(Object highValue) {
		this.highValue = highValue;
	}

	@Override
	public String toString() {
		return null;
	}

}
