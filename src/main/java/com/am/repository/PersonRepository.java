package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tperson;

public interface PersonRepository extends CrudRepository<Tperson, Long> , JpaSpecificationExecutor {
	Tperson findByNameperson(String username);

	Boolean existsByEmailperson(String mailperson);

	@Query("select v from Tperson v order by v.nameperson")
	List<Tperson> findAll();
	
	Tperson findByIdperson(Long idperson);

}
