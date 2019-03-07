package com.am.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.am.entity.Tview;

public interface ViewService {
	
	public List<Tview> findAll();
	
	public List<Tview> findAll(Specification spec);
	
	Tview findByIdview(Long idview);
	
	List<Tview> findByProgview(String progview);
	
	public Tview save(Tview tview);
	
	public void delete(Long idview);
		
}
