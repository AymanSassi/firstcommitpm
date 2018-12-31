package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Trole;
import com.am.entity.Tusersignin;
import com.am.entity.Tview;
import com.am.repository.RoleRepository;
import com.am.repository.UsersigninRepository;
import com.am.service.RoleService;
import com.am.service.UsersigninService;

@Service
public class UsersigninServiceImpl implements UsersigninService {

	@Autowired
	private UsersigninRepository usersigninRepository;

	public Tusersignin findByToken(String token)
	{
		return usersigninRepository.findByToken(token);
	}
	
	public Tusersignin save(Tusersignin usersignin) {
		return usersigninRepository.save(usersignin);
	}

	@Override
	public void delete(long id) {
		usersigninRepository.deleteById(id);
		
	}
	

}
