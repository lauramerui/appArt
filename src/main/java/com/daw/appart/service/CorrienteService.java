package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Artista;
import com.daw.appart.model.Corriente;
import com.daw.appart.repository.CorrienteRepository;

@Service
public class CorrienteService {
	
	@Autowired
	CorrienteRepository repositorio;
	
	public Corriente addCorriente(Corriente c) {
		return repositorio.save(c);
	}

	public List<Corriente>findAllCorriente() {
		return repositorio.findAll();
	}
	
	public Corriente findByCodCorriente(int cod) {
		return repositorio.findByCodCorriente(cod);
	}
	public Corriente editCorriente(Corriente c) {
		return repositorio.save(c);
	}
	public void deteleCorriente(Corriente c) {
		repositorio.delete(c);
	}
}
