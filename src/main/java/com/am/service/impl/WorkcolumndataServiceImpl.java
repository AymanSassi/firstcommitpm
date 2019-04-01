package com.am.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tperson;
import com.am.entity.Tticket;
import com.am.entity.Tworkcolumndata;
import com.am.repository.PersonRepository;
import com.am.repository.WorkdcolumndataRepository;

import com.am.service.PersonService;
import com.am.service.WorkcolumndataService;

@Service
public class WorkcolumndataServiceImpl implements WorkcolumndataService {
	
	@Autowired
	private WorkdcolumndataRepository workcolumndataRepository;
	
	@Override
	public Tworkcolumndata save(Tworkcolumndata tworkcolumndata) {
		// TODO Auto-generated method stub
		return workcolumndataRepository.save(tworkcolumndata);
		
	}

	@Override
	public List<Tworkcolumndata> saveAll(List<Tworkcolumndata> tworkcolumndata) {
		for(int i=0;i<tworkcolumndata.size();i++) {
			save(tworkcolumndata.get(i));
		}
		return tworkcolumndata;
	}









	@Override
	public List<Tworkcolumndata> findAll() {
		
			return workcolumndataRepository.findAll();
		

	}

	@Override
	public void delete(Long idsession) {
		workcolumndataRepository.deleteById(idsession);	}

	
	

}
