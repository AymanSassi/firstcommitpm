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
import com.am.entity.Tworkcolumndata;
import com.am.entity.Tworklinedata;
import com.am.entity.Tworkvaluedata;
import com.am.service.WorkcolumndataService;
import com.am.service.WorklinedataService;
import com.am.service.WorkvaluedataService;

@RestController
@RequestMapping("/workdata")
public class WorkdataResource {
	@Autowired
	private WorkcolumndataService workcolumndataService;

	@Autowired
	private WorklinedataService worklinedataService;

	@Autowired
	private WorkvaluedataService workvaluedataService;

	@RequestMapping(value = "/line/list", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tworklinedata> lineList(@RequestParam(required = true, value = "idsession") Long idsession,
			@RequestParam(required = false, value = "codeworkdata") String codeworkdata) {
		if (codeworkdata == null)
			return worklinedataService.findByIdsession(idsession);
		else
			return worklinedataService.findByIdsessionAndCodeworkdata(idsession, codeworkdata);
	}

	@RequestMapping(value = "/line/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tworklinedata> lineSave(@RequestBody Tworklinedata tworklinedata) {
		Tworklinedata tworklinedatasave = worklinedataService.save(tworklinedata);
		return new ResponseEntity<Tworklinedata>(tworklinedatasave, HttpStatus.OK);
	}

	@RequestMapping(value = "/line/saveall", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tworklinedata>> lineSaveAll(@RequestBody List<Tworklinedata> tworklinedata) {
		System.out.println("save");
		List<Tworklinedata> tworklinedatasave = worklinedataService.saveAll(tworklinedata);
		System.out.println("saveafter");
		return new ResponseEntity<List<Tworklinedata>>(tworklinedatasave, HttpStatus.OK);
	}

	@RequestMapping(value = "/column/list", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tworkcolumndata> workcolumndataList(@RequestParam(required = true, value = "idsession") Long idsession,
			@RequestParam(required = false, value = "codeworkdata") String codeworkdata) {
		if (codeworkdata == null)
			return workcolumndataService.findByIdsession(idsession);
		else
			return workcolumndataService.findByIdsessionAndCodeworkdata(idsession, codeworkdata);
	}

	@RequestMapping(value = "/column/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tworkcolumndata> save(@RequestBody Tworkcolumndata tworkcolumndata) {
		Tworkcolumndata tworkcolumndatasave = workcolumndataService.save(tworkcolumndata);
		return new ResponseEntity<Tworkcolumndata>(tworkcolumndatasave, HttpStatus.OK);
	}

	@RequestMapping(value = "/column/saveall", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tworkcolumndata>> columnSaveAll(@RequestBody List<Tworkcolumndata> tworkcolumndata) {
		List<Tworkcolumndata> tworkcolumndatasave = workcolumndataService.saveAll(tworkcolumndata);
		return new ResponseEntity<List<Tworkcolumndata>>(tworkcolumndatasave, HttpStatus.OK);
	}

	@RequestMapping(value = "/value/list", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tworkvaluedata> workvaluedataList(@RequestParam(required = true, value = "idsession") Long idsession,
			@RequestParam(required = false, value = "codeworkdata") String codeworkdata) {
		if (codeworkdata == null)
			return workvaluedataService.findByIdsession(idsession);
		else
			return workvaluedataService.findByIdsessionAndCodeworkdata(idsession, codeworkdata);
	}

	@RequestMapping(value = "/value/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tworkvaluedata> save(@RequestBody Tworkvaluedata tworkvaluedata) {
		Tworkvaluedata tworkvaluedatasave = workvaluedataService.save(tworkvaluedata);
		return new ResponseEntity<Tworkvaluedata>(tworkvaluedatasave, HttpStatus.OK);
	}

	@RequestMapping(value = "/value/saveall", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tworkvaluedata>> valueSaveAll(@RequestBody List<Tworkvaluedata> tworkvaluedata) {
		List<Tworkvaluedata> tworkvaluedatasave = workvaluedataService.saveAll(tworkvaluedata);
		return new ResponseEntity<List<Tworkvaluedata>>(tworkvaluedatasave, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public void delete(@RequestParam(required = true, value = "idsession") Long idsession,
			@RequestParam(required = false, value = "codeworkdata") String codeworkdata) {
		if (codeworkdata == null) {
			workcolumndataService.deleteByIdsession(idsession);
			worklinedataService.deleteByIdsession(idsession);
			workvaluedataService.deleteByIdsession(idsession);
		} else {
			workcolumndataService.deleteByIdsessionAndCodeworkdata(idsession, codeworkdata);
			worklinedataService.deleteByIdsessionAndCodeworkdata(idsession, codeworkdata);
			workvaluedataService.deleteByIdsessionAndCodeworkdata(idsession, codeworkdata);
		}
	}

}
