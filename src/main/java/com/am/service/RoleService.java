package com.am.service;

import java.util.List;

import com.am.entity.Trole;

public interface RoleService {
	
	public List<Trole> findAll();
	
	List<Trole> getRolesByUserid(Long userId);
	
	Trole findByIdrole(Long idrole);
	
}
