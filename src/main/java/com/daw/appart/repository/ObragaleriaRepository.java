package com.daw.appart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.appart.model.Obragaleria;

public interface ObragaleriaRepository extends JpaRepository<Obragaleria,Long>{

	List<Obragaleria> findByCodGaleria(int codGaleria);

	Obragaleria findByCodGaleriaAndCodObra(int codGaleria,int codObra);


}
