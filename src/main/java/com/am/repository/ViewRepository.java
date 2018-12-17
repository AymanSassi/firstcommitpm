package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Trole;
import com.am.entity.Tview;

public interface ViewRepository extends CrudRepository<Tview, Long> {
	
	@Query("select v from Tview v order by v.nameview")
	List<Tview> findAll();
	
	//public List<Tview> findAllByOrderByNameviewAsc();
	
	//public List<Tview> findAllByOrderByNameviewDesc();
	
	Tview findByIdview(Long idview);
	
}
