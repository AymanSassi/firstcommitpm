package com.am.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.am.entity.Tproduct;


public interface ProductService {
	
	public List<Tproduct> findAll();
	
	Tproduct findByIdproduct(Long idproduct);
	
	public Tproduct save(Tproduct tproduct);
	
	public void delete(Long idproduct);
		
}
