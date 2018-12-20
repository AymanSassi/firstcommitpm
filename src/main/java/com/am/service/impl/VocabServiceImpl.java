package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tview;
import com.am.entity.Tvocab;
import com.am.repository.VocabRepository;
import com.am.service.ViewService;
import com.am.service.VocabService;

@Service
public class VocabServiceImpl implements VocabService {

	@Autowired
	private VocabRepository vocabRepository;

	public List<Tvocab> findAll() {
		
		//return viewRepository.findAllByOrderByNameviewAsc();
		
		//return viewRepository.findAllByOrderByNameviewDesc();
		
		return vocabRepository.findAll();

	}

	@Override
	public Tvocab findByIdvocab(Long idvocab) {
		return vocabRepository.findByIdvocab(idvocab);
		
	}

	public Tvocab save(Tvocab tvocab) {
		return vocabRepository.save(tvocab);
	}

	public void delete(Long idvocab) {
		vocabRepository.deleteById(idvocab);
	}

	

}
