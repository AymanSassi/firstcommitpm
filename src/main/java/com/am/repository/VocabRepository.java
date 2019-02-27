
package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tvocab;

public interface VocabRepository extends CrudRepository<Tvocab, Long> ,JpaSpecificationExecutor  {
	
	@Query("select v from Tvocab v order by v.namevocab")
	List<Tvocab> findAll();
	
	Tvocab findByIdvocab(long idvocab);
	
}
