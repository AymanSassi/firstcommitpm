package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Trole;
import com.am.repository.RoleRepository;
import com.am.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Trole> findAll() {
		return roleRepository.findAll();

	}

	public List<Trole> getRolesByUserid(Long userId) {
		return roleRepository.getRolesByUserid(userId);
	}

}
