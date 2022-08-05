package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Obrafav;
import com.daw.appart.model.Vistaobrafav;
import com.daw.appart.repository.VistaobrafavRepository;

@Service
public class VistaObrafavService {
	@Autowired
	VistaobrafavRepository repositorio;


	public List<Vistaobrafav> findAllVistaObrasfav() {
		return repositorio.findAll();
	}	
	public Vistaobrafav findByCodObrafav(int codObrafav) {
		return repositorio.findByCodObraFav(codObrafav);
	}
	public List<Vistaobrafav> findByEmail(String email){
		return repositorio.findByEmail(email);
	}
	
	public List<Object>countObrasFav(){
		return repositorio.countObrasFav(PageRequest.of(0, 10));
	}

}
