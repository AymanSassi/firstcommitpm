package com.am.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tperson;
import com.am.entity.Tworklinedata;
import com.am.repository.PersonRepository;
import com.am.repository.WorkdlinedataRepository;

import com.am.service.PersonService;
import com.am.service.WorklinedataService;

@Service
public class WorklinedataServiceImpl implements WorklinedataService {
	
	@Autowired
	private WorkdlinedataRepository worklinedataRepository;
	
	@Override
	public Tworklinedata save(Tworklinedata tworklinedata) {
		// TODO Auto-generated method stub
		return worklinedataRepository.save(tworklinedata);
		
	}

	@Override
	public List<Tworklinedata> saveAll(List<Tworklinedata> tworklinedata) {
		for(int i=0;i<tworklinedata.size();i++) {
			save(tworklinedata.get(i));
		}
		return tworklinedata;
	}









	@Override
	public List<Tworklinedata> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
