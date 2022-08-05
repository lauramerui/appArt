package com.daw.appart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daw.appart.model.Usuario;

public interface UsuarioRespository extends JpaRepository<Usuario,Long> {
	Usuario findByEmail(String email);

	List<Usuario> findByEmailAndPassword(String email, String password);
}
