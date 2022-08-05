package com.daw.appart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.appart.model.Vistagaleria;

public interface VistagaleriaRepository extends JpaRepository<Vistagaleria,Long>{

	List<Vistagaleria> findByCodGaleria(int codGaleria);

	List<Vistagaleria> findByEmail(String email);
	
//	List<Vistagaleria>findDistinctVistagaleria(String email);


}
