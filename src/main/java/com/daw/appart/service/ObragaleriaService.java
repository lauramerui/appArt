package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Obrafav;
import com.daw.appart.model.Obragaleria;
import com.daw.appart.repository.ObragaleriaRepository;

@Service
public class ObragaleriaService {
	@Autowired
	ObragaleriaRepository repositorio;

	public Obragaleria addObra(Obragaleria o) {
		return repositorio.save(o);
	}
	public List<Obragaleria> findAllObragaleria() {
		return repositorio.findAll();
	}	
	public List<Obragaleria> findObragaleriaByCodGaleria(int codGaleria) {
		return repositorio.findByCodGaleria(codGaleria);
	}	
	public Obragaleria findByCodGaleriaAndCodObra(int codGaleria,int codObra) {
		return repositorio.findByCodGaleriaAndCodObra(codGaleria,codObra);
	}	
	public Obragaleria editObragaleria(Obragaleria o) {
		return repositorio.save(o);
	}
	public void deteleObragaleria(Obragaleria o) {
		repositorio.delete(o);
	}
	

}
