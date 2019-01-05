package com.am.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.am.entity.Tticket;

public interface TicketService {
	
	public List<Tticket> findAll();
	
	public List<Tticket> findAll(Specification spec);
	
	Tticket findByIdticket(Long idticket);
	
	public Tticket save(Tticket tticket);
	
	public void delete(Long idticket);
		
}
