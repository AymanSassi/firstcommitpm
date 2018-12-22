package com.am.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.am.entity.Tticket;
import com.am.repository.TicketRepository;
import com.am.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	public List<Tticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public Tticket findByIdticket(Long idticket) {
		return ticketRepository.findByIdticket(idticket);
	}

	public Tticket save(Tticket tticket) {
		return ticketRepository.save(tticket);
	}

	public void delete(Long idview) {
		ticketRepository.deleteById(idview);
	}

}
