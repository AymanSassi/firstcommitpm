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

import com.am.entity.Tworklinedata;
import com.am.service.WorklinedataService;



@RestController
@RequestMapping("/worklinedata")
public class WorklinedataResource {
	@Autowired
	private WorklinedataService worklinedataService;

	@RequestMapping(value = "/worklinedatalist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tworklinedata> worklinedataList() {
		return worklinedataService.findAll();
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tworklinedata> save(@RequestBody Tworklinedata tworklinedata) {
		Tworklinedata tworklinedatasave = worklinedataService.save(tworklinedata);
		return new ResponseEntity<Tworklinedata>(tworklinedatasave, HttpStatus.OK);
	}

	

	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tworklinedata>> saveAll(@RequestBody List<Tworklinedata> tworklinedata) {
		List<Tworklinedata> tworklinedatasave = worklinedataService.saveAll(tworklinedata);
		return new ResponseEntity<List<Tworklinedata>>(tworklinedatasave, HttpStatus.OK);
	}
	

}
