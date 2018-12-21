package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tproduct;
import com.am.entity.Tproductversion;
import com.am.repository.ProductVersionRepository;
import com.am.service.ProductVersionService;

;

@Service
public class ProductVersionServiceImpl implements ProductVersionService {

	@Autowired
	private ProductVersionRepository productVersionRepository;

	public List<Tproductversion> findAll() {
		
		//return viewRepository.findAllByOrderByNameviewAsc();
		
		//return viewRepository.findAllByOrderByNameviewDesc();
		
		return productVersionRepository.findAll();

	}

	@Override
	public Tproductversion findByIdproductversion(Long idproductversion) {
		return productVersionRepository.findByIdproductversion(idproductversion);
		
	}

	@Override
	public Tproductversion save(Tproductversion tproductversion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long idproductversion) {
		// TODO Auto-generated method stub
		
	}





	

	

}
