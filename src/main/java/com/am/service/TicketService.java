package com.am.service;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.am.entity.Tticket;
import com.am.util.Graph2d;

public interface TicketService {
	
	public List<Tticket> findAll();
	
	public List<Tticket> findAll(Specification spec);
	
	Tticket findByIdticket(Long idticket);
	
	public List<Graph2d> findCountGroupMonth();
	
	public List<Graph2d> findCountGroupProductStatus();
	
	public List<Graph2d> findFXorNBGrpReportertype();
	
	public Tticket save(Tticket tticket);
	
	public void delete(Long idticket);
		
}
