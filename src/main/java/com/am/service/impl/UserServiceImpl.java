package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.repository.UserRepository;
import com.am.service.UserService;
import com.am.entity.Tuser;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Tuser> findAll(){
		return userRepository.findAll();
		
	}

}
