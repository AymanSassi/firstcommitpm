package com.am.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tuserfirstry;

public interface UserRepository extends CrudRepository<Tuserfirstry, Long>{
	Tuserfirstry findByUserlogin(String userlogin);
	
	List<Tuserfirstry> findAll();
}
