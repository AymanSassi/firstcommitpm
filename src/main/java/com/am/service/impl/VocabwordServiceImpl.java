package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.am.entity.Tvocabword;
import com.am.repository.VocabwordRepository;
import com.am.service.VocabwordService;

@Service
public class VocabwordServiceImpl implements VocabwordService {
	@Autowired
	VocabwordRepository vocabwordReposiroty;

	public List<Tvocabword> findByCodevocab(String codevocab) {
		return vocabwordReposiroty.findByCodevocab(codevocab);

	}

	public List<Tvocabword> findAll(){
		return vocabwordReposiroty.findAll();

	}

	
}