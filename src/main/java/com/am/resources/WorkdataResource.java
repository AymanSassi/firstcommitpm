package com.am.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.am.entity.Tworkdata;
import com.am.service.WorkdataService;


@RestController
@RequestMapping("/workdata")
public class WorkdataResource {
	@Autowired
	private WorkdataService workdataService;

	@RequestMapping(value = "/workdatalist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tworkdata> workdataList() {
		return workdataService.findAll();
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tworkdata> save(@RequestBody Tworkdata tworkdata) {
		Tworkdata tworkdatasave = workdataService.save(tworkdata);
		return new ResponseEntity<Tworkdata>(tworkdatasave, HttpStatus.OK);
	}

	

	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tworkdata>> saveAll(@RequestBody List<Tworkdata> tworkdata) {
		List<Tworkdata> tworkdatasave = workdataService.saveAll(tworkdata);
		return new ResponseEntity<List<Tworkdata>>(tworkdatasave, HttpStatus.OK);
	}
	

}
