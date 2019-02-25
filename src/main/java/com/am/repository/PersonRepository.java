package com.am.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tperson;
import com.am.entity.Tproduct;

public interface PersonRepository extends CrudRepository<Tperson, Long> {
	

	@Query("select v from Tperson v order by v.nameperson")
	List<Tperson> findAll();
	
	Tperson findByIdperson(Long idperson);
	Tperson findByNameperson(String username);

	Boolean existsByEmailperson(String mailperson);
	
}
