package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Obra;
import com.daw.appart.model.Vistaobra;
import com.daw.appart.repository.VistaobraRepository;

@Service
public class VistaobraService {
	@Autowired
	VistaobraRepository repositorio;

	public List<Vistaobra> findAllVistaobras() {
		return repositorio.findAll();
	}
	
	public Vistaobra findByCodObra(int codObra) {
		return repositorio.findByCodObra(codObra);
	}

//	public List<Obra> findByCodArtista(int codArt) {
//		return repositorio.findByCodArtista(codArt);
//	}
//	public List<Obra> findByCodCorriente(int codCorr) {
//		return repositorio.findByCodCorriente(codCorr);
//	}
//	public List<String>findTecnicas(){
//		return repositorio.findDistinctTecnica();
//	}
//	public List<String>findUbicaciones(){
//		return repositorio.findDistinctUbicacion();
//	}
}
