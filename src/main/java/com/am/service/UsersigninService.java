package com.am.service;

import com.am.entity.Tusersignin;

public interface UsersigninService {

	Tusersignin findByToken(String token);

	void delete(long id);

}
