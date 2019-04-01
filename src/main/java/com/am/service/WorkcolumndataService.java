package com.am.service;

import java.util.List;

import com.am.entity.Tperson;
import com.am.entity.Tworkcolumndata;

public interface WorkcolumndataService {
	

	public Tworkcolumndata save(Tworkcolumndata tworkcolumndata);
	
	public List<Tworkcolumndata> saveAll(List<Tworkcolumndata> tworkcolumndata);

	public List<Tworkcolumndata> findAll();

	public void delete(Long idworkcolumndata);

}
