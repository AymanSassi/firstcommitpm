
package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tticket;


//public interface UserRepository 
//extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {}
public interface TicketRepository extends CrudRepository<Tticket, Long> , JpaSpecificationExecutor{
	
	@Query("select v from Tticket v order by v.dateticket desc")
	List<Tticket> findAll();
	
	Tticket findByIdticket(Long idticket);
	
}
