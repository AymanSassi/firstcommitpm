package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.am.entity.Tperson;
import com.am.entity.Tworklinedata;
import com.am.repository.PersonRepository;
import com.am.repository.WorkdlinedataRepository;

import com.am.service.PersonService;
import com.am.service.WorklinedataService;

@Service
@Transactional
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
		worklinedataRepository.saveAll(tworklinedata);
		return tworklinedata;
	}

	@Override
	public List<Tworklinedata> findByIdsession(Long idsession) {
		return worklinedataRepository.findByIdsession(idsession);
	}

	@Override
	public List<Tworklinedata> findByIdsessionAndCodeworkdata(Long idsession, String codeworkdata) {
		return worklinedataRepository.findByIdsessionAndCodeworkdata(idsession, codeworkdata);
	}

	@Override
	public void delete(Long idsession) {
		worklinedataRepository.deleteById(idsession);
	}

	@Override
	public void deleteByIdsession(Long idsession) {
		worklinedataRepository.deleteByIdsession(idsession);

	}

	@Override
	public void deleteByIdsessionAndCodeworkdata(Long idsession, String codeworkdata) {
		worklinedataRepository.deleteByIdsessionAndCodeworkdata(idsession, codeworkdata);

	}

}
