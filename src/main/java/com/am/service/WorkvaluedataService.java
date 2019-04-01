package com.am.service;

import java.util.List;

import com.am.entity.Tperson;
import com.am.entity.Tworkvaluedata;

public interface WorkvaluedataService {
	

	public Tworkvaluedata save(Tworkvaluedata tworkvaluedata);
	
	public List<Tworkvaluedata> saveAll(List<Tworkvaluedata> tworkvaluedata);

	public List<Tworkvaluedata> findAll();

	public void delete(Long idworkvaluedata);

}
