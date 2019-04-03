package com.am.service;

import java.util.List;

import com.am.entity.Tperson;
import com.am.entity.Tworklinedata;
import com.am.entity.Tworkvaluedata;

public interface WorkvaluedataService {

	public Tworkvaluedata save(Tworkvaluedata tworkvaluedata);

	public List<Tworkvaluedata> saveAll(List<Tworkvaluedata> tworkvaluedata);

	public void delete(Long idworkvaluedata);

	List<Tworkvaluedata> findByIdsession(Long idsession);

	List<Tworkvaluedata> findByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);

	void deleteByIdsession(Long idsession);

	void deleteByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);

}
