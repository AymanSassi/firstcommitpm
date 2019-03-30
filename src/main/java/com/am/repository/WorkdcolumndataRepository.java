package com.am.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tperson;
import com.am.entity.Tproduct;
import com.am.entity.Tticket;
import com.am.entity.Tworkcolumndata;
import com.am.entity.Tworklinedata;

public interface WorkdcolumndataRepository extends CrudRepository<Tworkcolumndata, Long> , JpaSpecificationExecutor {
	


}

