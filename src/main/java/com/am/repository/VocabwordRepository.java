
package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tvocabword;

public interface VocabwordRepository extends CrudRepository<Tvocabword, Long> ,JpaSpecificationExecutor  {
	
	@Query("select w from Tvocabword w join w.tvocab v where v.codevocab=?1 order by w.rownumber,w.codeword")
	List<Tvocabword> findByCodevocab(String codevocab);
	
	List<Tvocabword> findAll();
}
