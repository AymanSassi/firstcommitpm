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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.am.entity.Tvocab;
import com.am.service.VocabService;


//http://localhost:8181/user/userList
@RestController
@RequestMapping("/vocab")
public class VocabResource {
	@Autowired
	private VocabService vocabService;

	@RequestMapping(value = "/vocablist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tvocab> vocabList() {
		return vocabService.findAll();
	}
	
		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Tvocab geTvocab(@PathVariable("id") long id) {
		return vocabService.findByIdvocab(id);
	}	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tvocab> save(@RequestBody Tvocab Tvocab) {
		Tvocab tvocabsave=vocabService.save(Tvocab);
		return new ResponseEntity<Tvocab>(tvocabsave, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public void delete(@PathVariable("id") long id) {
		vocabService.delete(id);
	}

}
