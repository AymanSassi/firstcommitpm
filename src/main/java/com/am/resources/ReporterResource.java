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

import com.am.entity.Tperson;
import com.am.entity.Treporter;
import com.am.service.PersonService;
import com.am.service.ReporterService;


@RestController
@RequestMapping("/reporter")
public class ReporterResource {
	@Autowired
	private ReporterService reporterService;

	@RequestMapping(value = "/reporterlist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Treporter> reporterList() {
		return reporterService.findAll();
	}
}
