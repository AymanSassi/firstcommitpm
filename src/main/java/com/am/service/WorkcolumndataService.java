package com.am.service;

import java.util.List;

import com.am.entity.Tperson;
import com.am.entity.Tworkcolumndata;
import com.am.entity.Tworkvaluedata;

public interface WorkcolumndataService {

	public Tworkcolumndata save(Tworkcolumndata tworkcolumndata);

	public List<Tworkcolumndata> saveAll(List<Tworkcolumndata> tworkcolumndata);

	public void delete(Long idworkcolumndata);

	List<Tworkcolumndata> findByIdsession(Long idsession);

	List<Tworkcolumndata> findByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);

	void deleteByIdsession(Long idsession);

	void deleteByIdsessionAndCodeworkdata(Long idsession, String codeworkdata);
}
