package com.daw.appart.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daw.appart.model.Artista;
import com.daw.appart.model.Obra;
import com.daw.appart.model.Usuario;
import com.daw.appart.service.ArtistaService;
import com.daw.appart.service.ObraService;
import com.daw.appart.service.UsuarioService;

@RestController
public class PeticionesController {
	
	@Autowired
	private	ObraService obraService;
	@Autowired
	private	ArtistaService artistaService;
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping({"/cargarObras"})
	public List<Obra> cargarObras() {
		List<Obra>listaObras=obraService.findAllObras();
		return listaObras;
	}	
	@GetMapping({"/cargarArtistas"})
	public List<Artista> cargarArtistas() {
		List<Artista>listaArtistas=artistaService.findAllArtistas();
		return listaArtistas;
	}
	
	@GetMapping({"/enviarPuntos"})
	public String enviarPuntos(HttpServletRequest request) {
		String puntos=request.getParameter("puntos");
		System.out.println("PUNTOS: " + request.getParameter("puntos"));

		return "puntos recibidos " + puntos;
	}

	@PostMapping({"/comprobarPassw"})
	public boolean comprobarPassw(HttpServletRequest request,HttpSession sesion) {
		String password = request.getParameter("password");
		String email="";
		
		if(sesion.getAttribute("usuLogueado")!=null) {
			Usuario usuLogueado=(Usuario) sesion.getAttribute("usuLogueado");
			email = usuLogueado.getEmail();
		}else {
			email = request.getParameter("email");
		}
		
		
		Usuario usu = usuarioService.login(email, password);
		if(usu==null) {
			return false;
		}else {
			return true;
		}
	}
	@PostMapping({"/comprobarEmail"})
	public boolean comprobarEmail(HttpServletRequest request) {
		String email = request.getParameter("email");

		Usuario usu = usuarioService.findByEmail(email);
		if(usu==null) {
			return true;
		}else {
			return false;
		}
	}
}
