package com.am.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tperson;
import com.am.entity.Tproduct;
import com.am.entity.Tticket;
import com.am.entity.Tworkcolumndata;
import com.am.entity.Tworklinedata;
import com.am.entity.Tworkvaluedata;

public interface WorkdvaluedataRepository extends CrudRepository<Tworkvaluedata, Long> , JpaSpecificationExecutor {
	
	List<Tworkvaluedata> findByIdsession(Long idsession);

	List<Tworkvaluedata> findByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);
	
	void deleteByIdsession(Long idsession);
	
	void deleteByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);

}
