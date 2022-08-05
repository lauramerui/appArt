package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Artista;
import com.daw.appart.repository.ArtistaRepository;

@Service
public class ArtistaService {
	@Autowired
	ArtistaRepository repositorio;

	public Artista addArtista(Artista a) {
		return repositorio.save(a);
	}

	public List<Artista> findAllArtistas() {
		return repositorio.findAll();
	}

	public Artista findByCodArtista(int codArtista) {
		return repositorio.findByCodArtistaOrderByNombre(codArtista);
	}

	public Artista editArtista(Artista a) {
		return repositorio.save(a);
	}

	public void deteleArtista(Artista a) {
		repositorio.delete(a);
	}
	public List<String>findNacionalidades(){
		return repositorio.findDistinctNacionalidad();
	}
	public List<Artista>findByCorriente(int codCorr){
		return repositorio.findByCodCorriente(codCorr);
	}


}
