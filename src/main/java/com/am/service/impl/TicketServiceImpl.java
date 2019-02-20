package com.am.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.am.entity.Tticket;
import com.am.repository.TicketRepository;
import com.am.service.TicketService;
import com.am.util.Graph2d;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	
	public List<Graph2d> findCountGroupMonth(){
		List<Graph2d> list = ticketRepository.findCountGroupMonth();
		Map<String, Graph2d> m = new HashMap<>();
		List<Graph2d> finalList = new ArrayList<Graph2d>();
		for (Graph2d g : list) {
			m.put(g.getLigne(), g);
		}
		for (int i = 1; i <= 12; i++) {
			String s = i + "_2018";
			if (m.containsKey(s)) {
				finalList.add(m.get(s));
			} else
				finalList.add(new Graph2d(s, 0L));
		}
		return finalList;
		
	}
	public List<Graph2d> findCountGroupProductStatus(){
		List<Graph2d> list = ticketRepository.findCountGroupProductStatus();
		return list;
		
	}
	
	
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

	@Override
	public List<Tticket> findAll(Specification spec) {
		return ticketRepository.findAll(spec);
	}

}
