package com.am.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.am.entity.Trole;
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
			
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Tview getView(@PathVariable("id") long id) {
		return viewService.findByIdview(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Tview getView(@RequestParam("progview") String progView) {
		return viewService.findByProgview(progView);
	}	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tview> save(@RequestBody Tview tview) {
		Tview tviewsave=viewService.save(tview);
		return new ResponseEntity<Tview>(tviewsave, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public void delete(@PathVariable("id") long id) {
		viewService.delete(id);
	}

}
