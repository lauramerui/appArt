package com.daw.appart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.appart.model.Vistaobra;

public interface VistaobraRepository extends JpaRepository<Vistaobra,Long>{
	
//	@Query("SELECT v FROM vistaobra v WHERE cod_obra = ?1")
	Vistaobra findByCodObra(int codObra);

//	Obra findByCodObra(int codObra);
//	List <Obra> findByCodArtista(int codArtista);
//	List <Obra> findByCodCorriente(int codCorriente);
//	
//	@Query("SELECT DISTINCT tecnica FROM obra")
//	List <String> findDistinctTecnica();
//	
//	@Query("SELECT DISTINCT ubicacion FROM obra")
//	List <String> findDistinctUbicacion();
}
