package com.am.entityfilter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchCriteria {
	@JsonProperty("key")
	private String key;
	
	@JsonProperty("operation")
	private OpCriteria operation;
	
	@JsonProperty("value")
	private Object value;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public SearchCriteria() {

	}

	public SearchCriteria(String key, OpCriteria operation, Object value) {
		this.key = key;
		this.operation = operation;
		this.value = value;
	}

	public SearchCriteria(String key, String stringOperation, Object value) {
		this.key = key;
		this.operation = OpCriteria.fromString(stringOperation);
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