package com.am.entityfilter;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OpCriteria {
	// @JsonProperty("equals")
	equals, // @JsonProperty("like")
	like, // @JsonProperty("lessThan")
	lessThan, // @JsonProperty("greaterThan")
	greaterThan, likeIgnoreCase;

	@JsonCreator // This is the factory method and must be static
	public static OpCriteria fromString(String string) {
		switch (string) {
		case ":":
			return OpCriteria.equals;
		case "equals":
			return OpCriteria.equals;
		case "like":
			return OpCriteria.like;
		case "<":
			return OpCriteria.lessThan;
		case "lessThan":
			return OpCriteria.lessThan;
		case ">":
			return OpCriteria.greaterThan;
		case "greaterThan":
			return OpCriteria.greaterThan;
		case "likeIgnoreCase":
			return OpCriteria.likeIgnoreCase;
		}
		return OpCriteria.equals;
	}

}
