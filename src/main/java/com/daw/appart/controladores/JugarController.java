package com.daw.appart.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.appart.model.Usuario;
import com.daw.appart.service.ArtistaService;
import com.daw.appart.service.ObraService;
import com.daw.appart.service.PuntuacionService;

@Controller
public class JugarController {
	
	@Autowired
	private	ObraService obraService;
	@Autowired
	private	ArtistaService artistaService;
	@Autowired
	private PuntuacionService puntuacionService;

	@GetMapping({"/jugar"})
	public String jugar(Model model, HttpSession sesion) {
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());
		
//		List<Obra>listaObras=obraService.findAllObras();
//		List<Artista>listaArtistas=artistaService.findAllArtistas();

		return "jugar";
	}	
	
	@GetMapping({"/jugar-pregunta"})
	public String jugarPreguntas(Model model, @RequestParam(name="tipoJuego") String tipoJuego, HttpServletRequest request ,HttpSession sesion ) {
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());
		
		model.addAttribute("tipoJuego",tipoJuego);
		
		model.addAttribute("pregunta",obraService.getPregunta(tipoJuego));

		return "jugar-pregunta";
	}	
	@GetMapping({"/jugar-resultado"})
	public String resultadoJuego( @RequestParam(name="puntos") String puntos, Model model, HttpServletRequest request ,HttpSession sesion ) {
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());
		
		int fallos = 5 - Integer.parseInt(puntos);
		model.addAttribute("puntos", puntos);
		model.addAttribute("fallos", fallos);
		
		if(sesion.getAttribute("usuLogueado")!=null) {
			Usuario u=(Usuario) sesion.getAttribute("usuLogueado");
			puntuacionService.actualizarPuntuacion(u.getEmail(), Integer.parseInt(puntos));
			model.addAttribute("listaPuntuaciones",puntuacionService.findAllPuntuacion());
			model.addAttribute("puntosUsu",puntuacionService.findByEmail(u.getEmail()).getPuntos());
		}
		
		return "jugar-resultado";
	}	
	

	
}
