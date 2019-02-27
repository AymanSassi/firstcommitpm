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

import com.am.entity.Tvocab;
import com.am.entity.Tvocabword;
import com.am.service.VocabService;
import com.am.service.VocabwordService;


//http://localhost:8181/user/userList
@RestController
@RequestMapping("/vocabword")
public class VocabwordResource {
	@Autowired
	private VocabwordService vocabwordService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tvocabword> getVocabwordByparameter(@RequestParam(required = false,value = "codevocab") String codevocab) {
		if(codevocab!=null && !codevocab.isEmpty())
			return vocabwordService.findByCodevocab(codevocab);

		return vocabwordService.findAll();
	}


}
