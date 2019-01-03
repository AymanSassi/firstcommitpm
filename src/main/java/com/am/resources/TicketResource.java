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

import com.am.entity.Tticket;
import com.am.entityfilter.SearchCriteria;
import com.am.entityfilter.TicketSpecification;
import com.am.service.TicketService;

//http://localhost:8181/user/userList
@RestController
@RequestMapping("/ticket")
public class TicketResource {
	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "/ticketlist", method = RequestMethod.GET)
	@CrossOrigin
	public List<Tticket> ticketList() {
		//return ticketService.findAll();
		//JpaSpecificationExecutor
		TicketSpecification spec = 
	      new TicketSpecification(new SearchCriteria("idticket", ":", "10"));
		return ticketService.findAll();
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
