package com.daw.appart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.appart.model.Corriente;

public interface CorrienteRepository extends JpaRepository<Corriente, Long> {

	Corriente findByCodCorriente(int cod);
}
