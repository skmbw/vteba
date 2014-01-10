package com.vteba.tm.generic.criteria;

import java.util.List;

public class Restrictions {
	
	public static SimpleCriterion isNull(String name) {
		return new SimpleCriterion(name + " is null ");
	}
	
	public static SimpleCriterion isNotNull(String name) {
		return new SimpleCriterion(name + " is not null ");
	}
	
	public static SimpleCriterion eq(String name, Object value) {
		return new SimpleCriterion(name + " = :" + name, value);
	}
	
	public static SimpleCriterion ne(String name, Object value) {
		return new SimpleCriterion(name + " <> :" + name, value);
	}
	
	public static SimpleCriterion gt(String name, Object value) {
		return new SimpleCriterion(name + " > :" + name, value);
	}
	
	public static SimpleCriterion ge(String name, Object value) {
		return new SimpleCriterion(name + " >= :" + name, value);
	}
	
	public static SimpleCriterion lt(String name, Object value) {
		return new SimpleCriterion(name + " < :" + name, value);
	}
	
	public static SimpleCriterion le(String name, Object value) {
		return new SimpleCriterion(name + " <= :" + name, value);
	}
	
	public static InCriterion in(String name, List<?> value) {
		return new InCriterion(name + " in (:" + name + ") ", value);
	}
	
	public static InCriterion notIn(String name, List<?> value) {
		return new InCriterion(name + " not in (:" + name + ") ", value);
	}
	
	public static BetweenCriterion between(String name, Object lowValue, Object highValue) {
		return new BetweenCriterion(name + " between :l" + name + " and :h" + name, lowValue, highValue);
	}
	
	public static BetweenCriterion notBetween(String name, Object lowValue, Object highValue) {
		return new BetweenCriterion(name + " not between :l" + name + " and :h" + name, lowValue, highValue);
	}
}
