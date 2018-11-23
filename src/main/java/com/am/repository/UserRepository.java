package com.am.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tuser;

public interface UserRepository extends CrudRepository<Tuser, Long> {
	Tuser findByLoginuser(String userlogin);

	Boolean existsByLoginuser(String loginuser);

	//Boolean existsByMailuser(String mailuser);

	List<Tuser> findAll();
}
