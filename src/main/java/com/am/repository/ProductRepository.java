
package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tproduct;


public interface ProductRepository extends CrudRepository<Tproduct, Long> {
	
	@Query("select v from Tproduct v order by v.nameproduct")
	List<Tproduct> findAll();
	
	Tproduct findByIdproduct(Long idproduct);
	
	Tproduct findByNameproduct(String nameproduct);
	
}
