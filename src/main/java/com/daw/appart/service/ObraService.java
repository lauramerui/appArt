package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Obra;
import com.daw.appart.repository.ObraRepository;

@Service
public class ObraService {
	@Autowired
	ObraRepository repositorio;

	public Obra addObra(Obra o) {
		return repositorio.save(o);
	}

	public List<Obra> findAllObras() {
		return repositorio.findAll();
	}
	
	public List<Obra> findAllObrasOrdered() {
		return repositorio.findAllOrderByTitulo();
	}
	
	public Obra findByCodObra(int codObra) {
		return repositorio.findByCodObra(codObra);
	}
	public Obra editObra(Obra o) {
		return repositorio.save(o);
	}
	public void deteleObra(Obra o) {
		repositorio.delete(o);
	}
	public List<Obra> findByCodArtista(int codArt) {
		return repositorio.findByCodArtista(codArt);
	}
	public List<Obra> findByCodCorriente(int codCorr) {
		return repositorio.findByCodCorriente(codCorr);
	}
	public List<String>findTecnicas(){
		return repositorio.findDistinctTecnica();
	}
	public List<String>findUbicaciones(){
		return repositorio.findDistinctUbicacion();
	}
	
	public Obra obraAleatoria() {
		List<Obra>listaObras=this.findAllObras();
		int num= (int) (Math.random()*listaObras.size());
		
		return listaObras.get(num);
	}

	public String getPregunta(String tipoJuego) {
		String pregunta="";
		if(tipoJuego.equals("artista")) {
			pregunta="¿Quién es el artista?";
		}else if(tipoJuego.equals("obra")) {
			pregunta="¿Cómo se llama la obra?";
		}
		return pregunta;
	}
}
