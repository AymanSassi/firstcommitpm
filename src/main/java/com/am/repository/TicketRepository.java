
package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tticket;

public interface TicketRepository extends CrudRepository<Tticket, Long> {
	
	@Query("select v from Tticket v order by v.dateticket desc")
	List<Tticket> findAll();
	
	Tticket findByIdticket(long idticket);
	
}
