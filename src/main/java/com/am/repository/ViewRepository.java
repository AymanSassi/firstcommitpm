package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tview;
import com.am.entity.Tvocabword;

public interface ViewRepository extends CrudRepository<Tview, Long> , JpaSpecificationExecutor{
	
	@Query("select v from Tview v order by v.nameview")
	List<Tview> findAll();
	
	//<Tview> List<Tview> findAll(Specification<Tview> spec);
	
	//public List<Tview> findAllByOrderByNameviewAsc();
	
	//public List<Tview> findAllByOrderByNameviewDesc();
	
	Tview findByIdview(long idview);
	
	
	@Query("select t from Tview t where t.progview=?1")
	List<Tview> findByProgview(String progview);
}
