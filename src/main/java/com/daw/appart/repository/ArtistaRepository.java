package com.daw.appart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.appart.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista,Long>{

	Artista findByCodArtistaOrderByNombre(int codArtista);
	
	@Query("SELECT DISTINCT a.nacionalidad FROM artista a")
	List<String>  findDistinctNacionalidad();

	List<Artista> findByCodCorriente(int codCorr);

}
