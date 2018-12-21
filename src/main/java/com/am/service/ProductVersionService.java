package com.am.service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.am.entity.Tproductversion;


public interface ProductVersionService {
	
	public List<Tproductversion> findAll();
	
	Tproductversion findByIdproductversion(Long idproductversion);
	
	public Tproductversion save(Tproductversion tproductversion);
	
	public void delete(Long idproductversion);
		
}
