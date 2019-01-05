package com.am.resources;

import java.util.List;
import java.util.Map;

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

import com.am.entity.Tticket;
import com.am.entity.Tview;
import com.am.entityfilter.MyFilter;
import com.am.entityfilter.OpCriteria;
import com.am.service.TicketService;
import com.am.util.ClassInfo;

//http://localhost:8181/user/userList
@RestController
@RequestMapping("/ticket")
public class TicketResource {
	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "/ticketlist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tticket> ticketList() {
		return ticketService.findAll();
	}
	
	@RequestMapping(value = "/ticketlist2", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Tticket>> ticketlist2(@RequestBody Tticket tticket) {
		MyFilter<Tticket> myfilter = new MyFilter<>();
		
		List<Tticket> find;
		find = ticketService.findAll(myfilter.getSpecificationFromEntity(tticket));

		return new ResponseEntity<List<Tticket>>(find, HttpStatus.OK);

	}

		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public Tticket getTikcet(@PathVariable("id") long id) {
		return ticketService.findByIdticket(id);
	}	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<Tticket> save(@RequestBody Tticket tticket) {
		Tticket ticketsave=ticketService.save(tticket);
		return new ResponseEntity<Tticket>(ticketsave, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@CrossOrigin
	public void delete(@PathVariable("id") long id) {
		ticketService.delete(id);
	}

}
