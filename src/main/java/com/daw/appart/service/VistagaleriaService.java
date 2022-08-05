package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Vistagaleria;
import com.daw.appart.model.Vistaobra;
import com.daw.appart.repository.VistagaleriaRepository;

@Service
public class VistagaleriaService {
	@Autowired
	VistagaleriaRepository repositorio;

	public List<Vistagaleria> findAllVistagaleria() {
		return repositorio.findAll();
	}
	public List<Vistagaleria>findByCodgaleria(int codGaleria){
		return repositorio.findByCodGaleria(codGaleria);
	}
	public List<Vistagaleria>findByEmail(String email){
		return repositorio.findByEmail(email);
	}
}
