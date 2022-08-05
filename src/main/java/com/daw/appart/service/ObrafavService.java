package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Obra;
import com.daw.appart.model.Obrafav;
import com.daw.appart.repository.ObrafavRepository;

@Service
public class ObrafavService {
	@Autowired
	ObrafavRepository repositorio;

	public Obrafav addObra(Obrafav o) {
		return repositorio.save(o);
	}
	public List<Obrafav> findAllObrasfav() {
		return repositorio.findAll();
	}	
	public Obrafav findByCodObrafav(int codObrafav) {
		return repositorio.findByCodObraFav(codObrafav);
	}
	public List<Obrafav> findByEmail(String email){
		return repositorio.findByEmailUsu(email);
	}
	public Obrafav editObrafav(Obrafav o) {
		return repositorio.save(o);
	}
	public void deteleObrafav(Obrafav o) {
		repositorio.delete(o);
	}
	public Obrafav findByEmailCodObra(String email,int codObra) {
		return repositorio.findByEmailUsuAndCodObra(email, codObra);
	}
	public boolean checkMegusta(String email,int codObra) {
		Obrafav obra = repositorio.findByEmailUsuAndCodObra(email,codObra);
		if(obra==null) {
			return false;
		}else {
			return true;
		}
	}

}
