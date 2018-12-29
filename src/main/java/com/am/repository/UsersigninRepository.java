package com.am.repository;

import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tusersignin;

public interface UsersigninRepository extends CrudRepository<Tusersignin, Long> {
	Tusersignin findByToken(String token);
}
