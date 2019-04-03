package com.am.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tperson;
import com.am.entity.Tticket;
import com.am.entity.Tworkcolumndata;
import com.am.repository.PersonRepository;
import com.am.repository.WorkcolumndataRepository;

import com.am.service.PersonService;
import com.am.service.WorkcolumndataService;

@Service
public class WorkcolumndataServiceImpl implements WorkcolumndataService {
	
	@Autowired
	private WorkcolumndataRepository workcolumndataRepository;
	
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
	public void delete(Long idsession) {
		workcolumndataRepository.deleteById(idsession);	}

	@Override
	public List<Tworkcolumndata> findByIdsession(Long idsession) {
		return workcolumndataRepository.findByIdsession(idsession);
	}

	@Override
	public List<Tworkcolumndata> findByIdsessionAndCodeworkdata(Long idsession, String codeworkdata) {
		return workcolumndataRepository.findByIdsessionAndCodeworkdata(idsession, codeworkdata);
	}

	@Override
	public void deleteByIdsession(Long idsession) {
		workcolumndataRepository.deleteByIdsession(idsession);

	}

	@Override
	public void deleteByIdsessionAndCodeworkdata(Long idsession, String codeworkdata) {
		workcolumndataRepository.deleteByIdsessionAndCodeworkdata(idsession, codeworkdata);

	}
	
	

}
