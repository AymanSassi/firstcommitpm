package com.am.service;

import java.util.List;

import com.am.entity.Tticket;

public interface TicketService {
	
	public List<Tticket> findAll();
	
	Tticket findByIdticket(Long idticket);
	
	public Tticket save(Tticket tticket);
	
	public void delete(Long idticket);
		
}
