package com.am.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tperson;
import com.am.entity.Tworkvaluedata;
import com.am.repository.PersonRepository;
import com.am.repository.WorkdvaluedataRepository;

import com.am.service.PersonService;
import com.am.service.WorkvaluedataService;

@Service
public class WorkvaluedataServiceImpl implements WorkvaluedataService {
	
	@Autowired
	private WorkdvaluedataRepository workvaluedataRepository;
	
	@Override
	public Tworkvaluedata save(Tworkvaluedata tworkvaluedata) {
		// TODO Auto-generated method stub
		return workvaluedataRepository.save(tworkvaluedata);
		
	}

	@Override
	public List<Tworkvaluedata> saveAll(List<Tworkvaluedata> tworkvaluedata) {
		for(int i=0;i<tworkvaluedata.size();i++) {
			save(tworkvaluedata.get(i));
		}
		return tworkvaluedata;
	}









	@Override
	public List<Tworkvaluedata> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
