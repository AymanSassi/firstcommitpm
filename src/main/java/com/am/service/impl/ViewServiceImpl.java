package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tview;
import com.am.repository.ViewRepository;
import com.am.service.ViewService;

@Service
public class ViewServiceImpl implements ViewService {

	@Autowired
	private ViewRepository viewRepository;

	public List<Tview> findAll() {
		
		//return viewRepository.findAllByOrderByNameviewAsc();
		
		//return viewRepository.findAllByOrderByNameviewDesc();
		
		return viewRepository.findAll();

	}



}
