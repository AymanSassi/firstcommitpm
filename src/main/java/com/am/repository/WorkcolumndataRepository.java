package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tworkcolumndata;

public interface WorkcolumndataRepository extends CrudRepository<Tworkcolumndata, Long>, JpaSpecificationExecutor {

	List<Tworkcolumndata> findByIdsession(Long idsession);

	List<Tworkcolumndata> findByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);
	
	void deleteByIdsession(Long idsession);
	
	void deleteByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);
	

}
