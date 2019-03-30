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

import com.am.entity.Tworkvaluedata;
import com.am.service.WorkvaluedataService;



@RestController
@RequestMapping("/workvaluedata")
public class WorkvaluedataResource {
	@Autowired
	private WorkvaluedataService workvaluedataService;

	@RequestMapping(value = "/workvaluedatalist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tworkvaluedata> workvaluedataList() {
		return workvaluedataService.findAll();
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tworkvaluedata> save(@RequestBody Tworkvaluedata tworkvaluedata) {
		Tworkvaluedata tworkvaluedatasave = workvaluedataService.save(tworkvaluedata);
		return new ResponseEntity<Tworkvaluedata>(tworkvaluedatasave, HttpStatus.OK);
	}

	

	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tworkvaluedata>> saveAll(@RequestBody List<Tworkvaluedata> tworkvaluedata) {
		List<Tworkvaluedata> tworkvaluedatasave = workvaluedataService.saveAll(tworkvaluedata);
		return new ResponseEntity<List<Tworkvaluedata>>(tworkvaluedatasave, HttpStatus.OK);
	}
	

}
