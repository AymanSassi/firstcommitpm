package com.am.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tperson;
import com.am.entity.Tproduct;
import com.am.entity.Tticket;
import com.am.entity.Tworkdata;

public interface WorkdataRepository extends CrudRepository<Tworkdata, Long> , JpaSpecificationExecutor {
	


}
