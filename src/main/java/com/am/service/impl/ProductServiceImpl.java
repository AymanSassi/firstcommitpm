package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tproduct;
import com.am.repository.ProductRepository;
import com.am.service.ProductService;

;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	/*public List<Tproduct> findQuery(Tproduct tproduct)
	{
		productRepository.findAll();
		return null;
		
	}*/

	public List<Tproduct> findAll() {
		
		//return viewRepository.findAllByOrderByNameviewAsc();
		
		//return viewRepository.findAllByOrderByNameviewDesc();
		
		return productRepository.findAll();

	}

	@Override
	public Tproduct findByIdproduct(Long idproduct) {
		return productRepository.findByIdproduct(idproduct);
		
	}

	public Tproduct save(Tproduct tproduct) {
		return productRepository.save(tproduct);
	}

	public void delete(Long idproduct) {
		productRepository.deleteById(idproduct);
	}

	

	

}
