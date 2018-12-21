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

import com.am.entity.Tproduct;
import com.am.entity.Tproductversion;
import com.am.service.ProductVersionService;




//http://localhost:8181/user/userList
@RestController
@RequestMapping("/productversion")
public class ProductVersionResource {
	@Autowired
	private ProductVersionService productversionService;

	@RequestMapping(value = "/productversionlist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tproductversion> productversionList() {
		return productversionService.findAll();
	}
	
		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Tproductversion geTproductversion(@PathVariable("id") long id) {
		return productversionService.findByIdproductversion(id);
	}	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tproductversion> save(@RequestBody Tproductversion Tproductversion) {
		Tproductversion tproductversionsave=productversionService.save(Tproductversion);
		return new ResponseEntity<Tproductversion>(tproductversionsave, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public void delete(@PathVariable("id") long id) {
		productversionService.delete(id);
	}

}
