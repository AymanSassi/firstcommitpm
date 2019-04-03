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

public interface WorkcolumndataRepository extends CrudRepository<Tworkcolumndata, Long>, JpaSpecificationExecutor {

	List<Tworkcolumndata> findByIdsession(Long idsession);

	List<Tworkcolumndata> findByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);
	
	void deleteByIdsession(Long idsession);
	
	void deleteByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);
	

}
