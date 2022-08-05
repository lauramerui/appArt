package com.daw.appart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.appart.model.Obrafav;

public interface ObrafavRepository extends JpaRepository<Obrafav,Long>{

	Obrafav findByCodObraFav(int codObraFav);
	
	List<Obrafav> findByEmailUsu(String email);

	Obrafav findByEmailUsuAndCodObra(String email, int codObra);

}
