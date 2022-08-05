package com.daw.appart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.appart.model.Obra;

public interface ObraRepository extends JpaRepository<Obra,Long>{

	Obra findByCodObra(int codObra);
	List <Obra> findByCodArtista(int codArtista);
	List <Obra> findByCodCorriente(int codCorriente);
	
	@Query("SELECT DISTINCT tecnica FROM obra ORDER BY tecnica")
	List <String> findDistinctTecnica();
	
	@Query("SELECT DISTINCT ubicacion FROM obra ORDER BY ubicacion")
	List <String> findDistinctUbicacion();
	
	@Query("SELECT o FROM obra o ORDER BY o.titulo")
	List<Obra> findAllOrderByTitulo();
}
