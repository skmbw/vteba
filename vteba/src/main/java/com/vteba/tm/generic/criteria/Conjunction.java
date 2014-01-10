package com.vteba.tm.generic.criteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conjunction implements Criterion {
	private List<Criterion> junctionList = new ArrayList<Criterion>();
	
	public Conjunction() {
		
	}
	
	protected Conjunction(Criterion... criterions) {
		Collections.addAll(junctionList, criterions);
	}
	
	public String toQuery() {
		return null;
	}
}
