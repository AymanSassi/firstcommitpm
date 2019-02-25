package com.am.resources;

public class ReporterResource {

}

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
import com.am.service.PersonService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
	// commented
	/*
	 * @RequestMapping(value = "/productlistquery", method = RequestMethod.GET)
	 * 
	 * @CrossOrigin public List<Tproduct> productQuery(@RequestBody Tproduct
	 * tproduct) { return productService.findQuery(tproduct); }
	 */

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Treporter geTreporter(@RequestParam(required = false, value = "id") Long id,@RequestParam(required = false, value = "nameperson") String nameperson) {
		if(nameperson!=null)
			return personService.findByNameperson(nameperson);
		else if (id != null)
			return personService.findByIdperson(id);
		return null;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tperson> save(@RequestBody Tperson tperson) {
		Tperson tpersonsave = personService.save(tperson);
		return new ResponseEntity<Tperson>(tpersonsave, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public void delete(@PathVariable("id") long id) {
		personService.delete(id);
	}

}
