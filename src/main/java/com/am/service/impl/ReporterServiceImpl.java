package com.am.service.impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Treporter;
import com.am.repository.ReporterRepository;
import com.am.service.ReporterService;

@Service
public class ReporterServiceImpl implements ReporterService {

	@Autowired
	private ReporterRepository reporterRepository;

	
	
	
	
	public List<Treporter> findAll() {
		return reporterRepository.findAll();
	}

	
}
