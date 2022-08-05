package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Galeria;
import com.daw.appart.model.Obrafav;
import com.daw.appart.repository.GaleriaRepository;

@Service
public class GaleriaService {
	@Autowired
	GaleriaRepository repositorio;

	public Galeria addGaleria(Galeria g) {
		return repositorio.save(g);
	}
	public List<Galeria> findAllGaleria() {
		return repositorio.findAll();
	}	
	public List<Galeria> findByEmail(String email){
		return repositorio.findByEmailUsu(email);
	}
	public Galeria findByCodgaleria(int codGaleria){
		return repositorio.findByCodGaleria(codGaleria);
	}
	public Galeria editGaleria(Galeria g) {
		return repositorio.save(g);
	}
	public void deteleGaleria(Galeria g) {
		repositorio.delete(g);
	}

}
