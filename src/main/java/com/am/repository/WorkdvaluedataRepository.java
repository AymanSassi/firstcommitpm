package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tworkvaluedata;

public interface WorkdvaluedataRepository extends CrudRepository<Tworkvaluedata, Long> , JpaSpecificationExecutor {
	
	List<Tworkvaluedata> findByIdsession(Long idsession);

	List<Tworkvaluedata> findByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);
	
	void deleteByIdsession(Long idsession);
	
	void deleteByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);

}
