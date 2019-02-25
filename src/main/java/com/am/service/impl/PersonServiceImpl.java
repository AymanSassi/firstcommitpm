package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tperson;
import com.am.repository.PersonRepository;
import com.am.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<Tperson> findAll() {
			return personRepository.findAll();
	}

	@Override
	public Tperson findByIdperson(Long idperson) {
		return personRepository.findByIdperson(idperson);
		
	}

	public Tperson save(Tperson tperson) {
		return personRepository.save(tperson);
	}

	public void delete(Long idperson) {
		personRepository.deleteById(idperson);
	}

	@Override
	public Tperson findByNameperson(String nameperson) {
		return personRepository.findByNameperson(nameperson);
	}

}
