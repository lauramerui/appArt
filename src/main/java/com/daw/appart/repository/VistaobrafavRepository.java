package com.daw.appart.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.daw.appart.model.Vistaobra;
import com.daw.appart.model.Vistaobrafav;

public interface VistaobrafavRepository extends JpaRepository<Vistaobrafav,Long>{
	
	List<Vistaobrafav> findByEmail(String email);

	Vistaobrafav findByCodObraFav(int codObrafav);
	
	@Query("SELECT v.tituloObra, COUNT(v.tituloObra) AS c FROM vistafavs AS v  GROUP BY v.tituloObra ORDER BY c DESC")
	List<Object> countObrasFav(PageRequest pageRequest);
	


}
