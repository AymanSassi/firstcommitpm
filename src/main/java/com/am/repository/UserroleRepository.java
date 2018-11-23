package com.am.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tuserrole;

public interface UserroleRepository extends CrudRepository<Tuserrole, Long> {
	List<Tuserrole> findAll();
}
