package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tperson;
import com.am.entity.Tworkdata;
import com.am.repository.PersonRepository;
import com.am.repository.WorkdataRepository;
import com.am.service.PersonService;
import com.am.service.WorkdataService;

@Service
public class WorkdataServiceImpl implements WorkdataService {
	
	@Autowired
	private WorkdataRepository workdataRepository;
	
	@Override
	public Tworkdata save(Tworkdata tworkdata) {
		// TODO Auto-generated method stub
		return workdataRepository.save(tworkdata);
		
	}

	@Override
	public List<Tworkdata> saveAll(List<Tworkdata> tworkdata) {
		for(int i=0;i<tworkdata.size();i++) {
			save(tworkdata.get(i));
		}
		return tworkdata;
	}









	@Override
	public List<Tworkdata> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
