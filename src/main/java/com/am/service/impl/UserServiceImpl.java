package com.am.service.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.am.entity.Tuser;
import com.am.entity.Tuserrole;
import com.am.repository.PersonRepository;
import com.am.repository.RoleRepository;
import com.am.repository.UserRepository;
import com.am.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Transactional
	public Tuser createUser(Tuser user, Set<Tuserrole> userRoles) {
		Tuser localUser = userRepository.findByLoginuser(user.getLoginuser());

		if (localUser != null) {
			LOG.info("User with userlogin {} already exist. Nothing will be done. ", user.getLoginuser());
		} else {
			for (Tuserrole ur : userRoles) {
				roleRepository.save(ur.getTrole());
			}

			user.getTuserroles().addAll(userRoles);

			localUser = userRepository.save(user);
		}

		return localUser;
	}

	@Override
	public List<Tuser> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Tuser findByLoginuser(String login) {
		return userRepository.findByLoginuser(login);
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Tuser user = userRepository.findByLoginuser(username);
		if (user == null)
			throw new UsernameNotFoundException("Userlogin Not Found with -> username or email : " + username);
		Hibernate.initialize(user.getAuthorities());
		return user;
	}

}
