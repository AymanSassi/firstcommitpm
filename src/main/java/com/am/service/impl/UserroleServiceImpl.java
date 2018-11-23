package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.repository.UserroleRepository;
import com.am.service.UserroleService;
import com.am.entity.Tuserrole;


@Service
public class UserroleServiceImpl implements UserroleService{
	
	@Autowired
	private UserroleRepository userroleRepository;
	
	public List<Tuserrole> findAll(){
		return userroleRepository.findAll();
	}
}
