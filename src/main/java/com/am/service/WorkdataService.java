package com.am.service;

import java.util.List;

import com.am.entity.Tperson;
import com.am.entity.Tworkdata;

public interface WorkdataService {
	

	public Tworkdata save(Tworkdata tworkdata);
	
	public List<Tworkdata> saveAll(List<Tworkdata> tworkdata);

	public List<Tworkdata> findAll();

	

}
