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

	@Override
	public Tview findByIdview(Long idview) {
		return viewRepository.findByIdview(idview);
		
	}

	public Tview save(Tview tview) {
		return viewRepository.save(tview);
	}

	public void delete(Long idview) {
		viewRepository.deleteById(idview);
	}

}
