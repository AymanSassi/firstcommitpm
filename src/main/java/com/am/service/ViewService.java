package com.am.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.am.entity.Tview;

public interface ViewService {
	
	public List<Tview> findAll();
	
	Tview findByIdview(Long idview);
	
	public Tview save(Tview tview);
	
	public void delete(Long idview);
		
}
