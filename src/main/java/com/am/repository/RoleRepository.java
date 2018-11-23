package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Trole;

public interface RoleRepository extends CrudRepository<Trole, Long> {
	List<Trole> findAll();

	Trole findByNamerole(String namerole);

	@Query("select r from Tuserrole ur JOIN ur.tuser u JOIN ur.trole r where u.iduser=?1 and r.enabledrole=1")
	List<Trole> getRolesByUserid(Long userId);
}
