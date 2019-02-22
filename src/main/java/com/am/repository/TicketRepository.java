
package com.am.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.am.entity.Tticket;
import com.am.util.Graph2d;

public interface TicketRepository extends CrudRepository<Tticket, Long>, JpaSpecificationExecutor {

	@Query(value = "select new com.am.util.Graph2d(MONTH(t.dateticket)||'_'||YEAR(t.dateticket),count(t)) from Tticket t group by MONTH(t.dateticket)||'/'||YEAR(t.dateticket)")
	public List<Graph2d> findCountGroupMonth();

	@Query(value = "select new com.am.util.Graph2d(v.idvocabword||';'||v.nameword,p.idproduct||';'||p.nameproduct,count(t)) from Tticket t join t.tproduct p,Tvocabword v join Tvocab b on v.tvocab.idvocab=b.idvocab where t.vocticketstatus=v.idvocabword and b.codevocab='VOCTICKETSTATUS' group by v.idvocabword||';'||v.nameword,p.idproduct||';'||p.nameproduct")
	public List<Graph2d> findCountGroupProductStatus();

	@Query(value = "select new com.am.util.Graph2d(r.isinternal||'',v.icodeword||';'||v.nameword,count(t)) from Tticket t join t.tproduct p join t.treporter r,Tvocabword v join Tvocab b on v.tvocab.idvocab=b.idvocab where t.vocticketresol=v.idvocabword and b.codevocab='VOCTICKETRESOL' and v.icodeword in('FX','NB') group by r.isinternal||'',v.icodeword||';'||v.nameword")
	public List<Graph2d> findFXorNBGrpReportertype();

	@Query("select v from Tticket v order by v.dateticket desc")
	List<Tticket> findAll();

	Tticket findByIdticket(Long idticket);

}
