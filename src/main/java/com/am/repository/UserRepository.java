package com.am.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tuser;

public interface UserRepository extends CrudRepository<Tuser, Long>{
	Tuser findByLoginuser(String userlogin);
	
	List<Tuser> findAll();
}
