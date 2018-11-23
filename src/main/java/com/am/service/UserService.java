package com.am.service;

import java.util.List;

import com.am.entity.Tuser;

public interface UserService {
	
	public List<Tuser> findAll();
	
	public Tuser findByLoginuser(String login);
	
}
