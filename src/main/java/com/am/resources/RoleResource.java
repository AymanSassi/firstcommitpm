package com.am.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.am.entity.Trole;
import com.am.entity.Tuser;
import com.am.service.RoleService;
import com.am.service.UserService;

//http://localhost:8181/user/userList
@RestController
@RequestMapping("/role")
public class RoleResource {
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/roleList", method = RequestMethod.GET)
	@CrossOrigin
	public List<Trole> roleList() {
		return roleService.findAll();
	}

}
