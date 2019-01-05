package com.am.entityfilter;

public class SearchCriteria {
    private String key;
    private OpCriteria operation;
    private Object value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public SearchCriteria(String key, OpCriteria operation, Object value) {
		super();
		this.key = key;
		this.operation = operation;
		this.value = value;
	}
	
	public SearchCriteria(String key, Object value) {
		super();
		this.key = key;
		this.operation = OpCriteria.equals;
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public OpCriteria getOperation() {
		return operation;
	}
	public void setOperation(OpCriteria operation) {
		this.operation = operation;
	}
	
	
}