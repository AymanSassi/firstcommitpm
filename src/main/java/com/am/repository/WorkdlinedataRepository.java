package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tworklinedata;

public interface WorkdlinedataRepository extends CrudRepository<Tworklinedata, Long> , JpaSpecificationExecutor {
	
	List<Tworklinedata> findByIdsession(Long idsession);
	
	List<Tworklinedata> findByIdsessionAndCodeworkdata(Long idsession,String codeworkdata);
	
	void deleteByIdsession(Long idsession);
	
	void deleteByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);
	

}
