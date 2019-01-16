package com.am.entityfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.am.entity.Tproduct;
import com.am.entity.Tticket;
import com.am.util.ClassInfo;
import com.google.common.base.Splitter.MapSplitter;

public class MyFilter<T> {

	private List<SearchCriteria> conditions = new ArrayList<>();

	public void addCondition(SearchCriteria searchCriteria) {
		conditions.add(searchCriteria);
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
					Path<?> p = null;
					String[] items = (s.getKey()).split("\\.");
					List<String> itemList = new ArrayList<String>(Arrays.asList(items));
					if (itemList.size()>1) {
						// Join<T, ?> masterJoin = root.join(s.getKey());
						// p = masterJoin.get(s.getMasterAttribute());
						Join<?, ?> join = null;//root.join(s.getKey());
						for (int i = 0; i < itemList.size()-1; i++) {
							if (i == 0) {
								join = root.join(itemList.get(i));
							} else {
								join = join.join(itemList.get(i));
							}
							

							// Join<Series,Dossier> join1 = series.join(Series_.dossiers);

							// Join<Dossier, Item> join2 = join1.join(Dossier_.items);

						}
						p = join.get(itemList.get(itemList.size()-1));

					} else {
						p = root.get(s.getKey());
					}
					switch (s.getOperation()) {
					case equals:
						predicates.add(builder.equal(p, s.getValue()));
						break;
					case like:
						if (s.getValue() != null) {
							if (p.getJavaType() == String.class) {
								predicates.add(builder.like(p.as(String.class), s.getValue().toString()));
							} else {
								predicates.add(builder.equal(p, s.getValue()));
							}
						}
						break;
					case lessThan:
						predicates.add(builder.lessThanOrEqualTo(p.as(Comparable.class), (Comparable) s.getValue()));
						break;
					case greaterThan:
						predicates.add(builder.greaterThanOrEqualTo(p.as(Comparable.class), (Comparable) s.getValue()));
						break;
					case likeIgnoreCase:
						// System.out.println(s.getKey()+"="+s.getValue());
						if (s.getValue() != null) {
							if (p.getJavaType() == String.class) {
								predicates.add(builder.like(builder.lower(p.as(String.class)),
										s.getValue().toString().toLowerCase()));
							} else {
								predicates.add(builder.equal(p, s.getValue()));
							}
						}
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

	public Specification<T> getSpecificationFromEntity(Object record, OpCriteria opCriteria) {
		if (record == null)
			return getSpecification();

		Map<String, Object> list = ClassInfo.getFieldValues(record, true);
		System.out.println("LIST=" + list);
		if (list != null && !list.isEmpty()) {
			for (Map.Entry<String, Object> m : list.entrySet()) {
				addCondition(m.getKey(), opCriteria, m.getValue().toString());
			}
		}
		return getSpecification();
	}

}
