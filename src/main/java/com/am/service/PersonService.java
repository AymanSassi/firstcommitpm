package com.am.service;

import java.util.List;



import com.am.entity.Tperson;



public interface PersonService {
public List<Tperson> findAll();
	
	
		
	Tperson findByIdperson(Long idperson);
	
	Tperson findByNameperson(String nameperson);
	
	public Tperson save(Tperson tperson);
	
	public void delete(Long idperson);

}
