package com.am.entityfilter;

public enum OpCriteria {
	equals, like, lessThan, greaterThan;

	public static OpCriteria toEnum(String value)
	{
		switch (value) {
		case ":":
			return OpCriteria.equals;
		case "like":
			return OpCriteria.like;
		case "<":
			return OpCriteria.lessThan;
		case ">":
			return OpCriteria.greaterThan;
		}
		return OpCriteria.equals;
		
	}
	
}
