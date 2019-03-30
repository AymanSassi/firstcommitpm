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

import com.am.entity.Tworkcolumndata;
import com.am.service.WorkcolumndataService;





@RestController
@RequestMapping("/workcolumn")
public class WorkcolumnResource {
	@Autowired
	private WorkcolumndataService workcolumndataService;

	@RequestMapping(value = "/workcolumndatalist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tworkcolumndata> workcolumndataList() {
		return workcolumndataService.findAll();
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tworkcolumndata> save(@RequestBody Tworkcolumndata tworkcolumndata) {
		Tworkcolumndata tworkcolumndatasave = workcolumndataService.save(tworkcolumndata);
		return new ResponseEntity<Tworkcolumndata>(tworkcolumndatasave, HttpStatus.OK);
	}

	

	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tworkcolumndata>> saveAll(@RequestBody List<Tworkcolumndata> tworkcolumndata) {
		List<Tworkcolumndata> tworkcolumndatasave = workcolumndataService.saveAll(tworkcolumndata);
		return new ResponseEntity<List<Tworkcolumndata>>(tworkcolumndatasave, HttpStatus.OK);
	}
	

}
