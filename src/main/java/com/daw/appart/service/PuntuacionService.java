package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Puntuacion;
import com.daw.appart.model.Usuario;
import com.daw.appart.repository.PuntuacionRespository;

@Service
public class PuntuacionService {
	@Autowired
	PuntuacionRespository repositorio;

	public Puntuacion addPuntuacion(Puntuacion u) {
		return repositorio.save(u);
	}

	public List<Puntuacion> findAllPuntuacion() {
		return repositorio.findAllOrderByPuntos(PageRequest.of(0, 10));
	}
	public Puntuacion findByEmail(String email) {
		return repositorio.findByEmail(email);
	}
	public Puntuacion editPuntuacion(Puntuacion e) {
		return repositorio.save(e);
	}
	public void detelePuntuacion(Puntuacion e) {
		repositorio.delete(e);
	}
	public Puntuacion actualizarPuntuacion(String email, int puntos) {
		Puntuacion p=repositorio.findByEmail(email);
		if(p==null) {
			p=new Puntuacion();
			p.setEmail(email);
		}
		int puntosAct = p.getPuntos()+puntos;
		p.setPuntos(puntosAct);
		repositorio.save(p);
		
		return p;
	}
}
