package com.vteba.tm.generic.criteria;

import java.util.List;

public class InCriterion implements Criterion {
	private String expression;
	private String label;
	private List<?> value;

	public InCriterion() {
		super();
	}

	public InCriterion(String expression, String label, List<?> value) {
		super();
		this.expression = expression;
		this.label = label;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "InCriterion [expression=" + expression + ", value=" + value + "]";
	}
	
}
