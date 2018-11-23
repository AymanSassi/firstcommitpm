package com.am.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tperson;

public interface PersonRepository extends CrudRepository<Tperson, Long> {
	Tperson findByNameperson(String username);

	Boolean existsByEmailperson(String mailperson);

	List<Tperson> findAll();
}
