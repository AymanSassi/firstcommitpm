package com.am.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.am.entity.Tvocab;

public interface VocabService {
	
	public List<Tvocab> findAll();
	
	Tvocab findByIdvocab(Long idvocab);
	
	public Tvocab save(Tvocab tvocab);
	
	public void delete(Long idvocab);
		
}
