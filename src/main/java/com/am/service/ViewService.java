package com.am.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.am.entity.Tview;

public interface ViewService {
	
	public List<Tview> findAll();
	
	Tview findByIdview(Long idview);
	
	Tview findByProgview(String progview);
	
	public Tview save(Tview tview);
	
	public void delete(Long idview);
		
}
