package com.am.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.am.entity.Tview;
import com.am.service.ViewService;

//http://localhost:8181/user/userList
@RestController
@RequestMapping("/view")
public class ViewResource {
	@Autowired
	private ViewService viewService;

	@RequestMapping(value = "/viewlist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tview> viewList() {
		return viewService.findAll();
	}
	
	
	
	

}
