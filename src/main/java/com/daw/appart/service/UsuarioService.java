package com.daw.appart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.appart.model.Usuario;
import com.daw.appart.repository.UsuarioRespository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRespository repositorio;

	public Usuario addUser(Usuario u) {
		return repositorio.save(u);
	}

	public List<Usuario> findAllUser() {
		return repositorio.findAll();
	}
	
	public Usuario findByEmail(String email) {
		return repositorio.findByEmail(email);
	}
	public Usuario editUser(Usuario e) {
		return repositorio.save(e);
	}
	public void deteleUser(Usuario e) {
		repositorio.delete(e);
	}
	public Usuario login(String email, String password) {
		List<Usuario>list=repositorio.findByEmailAndPassword(email,password);
		Usuario usu = null;
		if(!list.isEmpty()) {
			usu = (repositorio.findByEmailAndPassword(email,password)).get(0);
		}
		System.out.println("usu logueado encontrado " + usu);
		return usu;
	}

}
