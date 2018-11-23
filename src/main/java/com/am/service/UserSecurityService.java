package com.am.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.am.entity.Tuser;
import com.am.repository.UserRepository;

@Service
public class UserSecurityService implements UserDetailsService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);
	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userlogin) throws UsernameNotFoundException {
		Tuser user = userRepository.findByLoginuser(userlogin);
		if(null == user) {
			LOG.warn("Userlogin {} not found", userlogin);
			throw new UsernameNotFoundException("Userlogin "+userlogin+" not found");
		}
		return user;
	}
}
