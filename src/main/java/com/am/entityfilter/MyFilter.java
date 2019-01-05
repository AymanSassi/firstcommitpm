package com.am.entityfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.am.util.ClassInfo;

public class MyFilter<T> {

	private List<SearchCriteria> conditions = new ArrayList<>();

	public void addCondition(SearchCriteria searchCriteria) {
		conditions.add(searchCriteria);
	}

	public void addCondition(String key, Object value) {
		conditions.add(new SearchCriteria(key, value));
	}

	public void addCondition(String key, OpCriteria opCriteria, Object value) {
		conditions.add(new SearchCriteria(key, opCriteria, value));
	}

	public Specification<T> getSpecification() {
		if (conditions.size() == 0)
			return null;
		Specification<T> specification = new Specification<T>() {
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				for (SearchCriteria s : conditions) {
					switch (s.getOperation()) {
					case equals:
						predicates.add(builder.equal(root.get(s.getKey()), s.getValue()));
						break;
					case like:
						predicates.add(builder.like(root.get(s.getKey()), s.getValue().toString()));
						break;
					case lessThan:
						predicates.add(builder.lessThanOrEqualTo(root.get(s.getKey()), s.getValue().toString()));
						break;
					case greaterThan:
						predicates.add(builder.greaterThanOrEqualTo(root.get(s.getKey()), s.getValue().toString()));
						break;

					default:
						break;
					}
				}

				return builder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		return specification;
	}

	public Specification<T> getSpecificationFromEntity(Object record) {
		if (record == null)
			return getSpecification();

		Map<String, Object> list = ClassInfo.getFieldValues(record, true);
		System.out.println("LIST=" + list);
		if (list != null && !list.isEmpty()) {
			for (Map.Entry<String, Object> m : list.entrySet()) {
				addCondition(m.getKey(), OpCriteria.equals, m.getValue());
			}
		}
		return getSpecification();
	}

}
