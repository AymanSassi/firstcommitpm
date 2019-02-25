

package com.am.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Treporter;



public interface ReporterRepository extends CrudRepository<Treporter, Long> {
	

	@Query("select v from Treporter v order by v.idreporter")
	List<Treporter> findAll();
	
	Treporter findByIdreporter(Long idreporter);
	//Tperson findByNameperson(String username);

	Boolean existsByEmailperson(String mailperson);
	
}
