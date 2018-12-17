package com.am.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.am.entity.Tuser;
import com.am.service.UserService;
//http://localhost:8181/user/userList
@RestController
@RequestMapping("/user")
public class UserResource {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public List<Tuser> bookList() {
		return userService.findAll();
	}
	
}
