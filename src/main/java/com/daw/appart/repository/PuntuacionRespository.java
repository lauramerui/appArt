package com.daw.appart.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.appart.model.Puntuacion;
import com.daw.appart.model.Usuario;

public interface PuntuacionRespository extends JpaRepository<Puntuacion,Long> {

	Puntuacion findByEmail(String email);
	
	@Query("SELECT p FROM puntuacion p ORDER BY puntos DESC")
	List<Puntuacion> findAllOrderByPuntos(PageRequest pageRequest);

}
