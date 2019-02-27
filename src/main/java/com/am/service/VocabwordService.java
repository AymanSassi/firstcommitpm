package com.am.service;

import java.util.List;

import com.am.entity.Tvocabword;

public interface VocabwordService {
	
	List<Tvocabword> findByCodevocab(String codevocab);
	
	List<Tvocabword> findAll();

}
