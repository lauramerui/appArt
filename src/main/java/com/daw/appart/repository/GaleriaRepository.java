package com.daw.appart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.appart.model.Galeria;
import com.daw.appart.model.Obrafav;

public interface GaleriaRepository extends JpaRepository<Galeria,Long>{
	
	List<Galeria> findByEmailUsu(String email);

	Galeria findByCodGaleria(int codGaleria);

}
