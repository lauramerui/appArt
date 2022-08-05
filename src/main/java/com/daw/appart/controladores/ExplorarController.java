package com.daw.appart.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.appart.model.Artista;
import com.daw.appart.model.Usuario;
import com.daw.appart.service.ArtistaService;
import com.daw.appart.service.CorrienteService;
import com.daw.appart.service.ObraService;

@Controller
public class ExplorarController {
	
	@Autowired
	private	ObraService obraService;
	@Autowired
	private	ArtistaService artistaService;
	@Autowired
	private CorrienteService corrienteService;
	
	@GetMapping({"/explorar"})
	public String explorar(Model model) {
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());
		
		model.addAttribute("listaObras", obraService.findAllObrasOrdered());
		model.addAttribute("listaTecnicas",obraService.findTecnicas());
		model.addAttribute("listaUbic",obraService.findUbicaciones());
		model.addAttribute("listaArtistas",artistaService.findAllArtistas());
		
		return "explorar";
	}
	
	@GetMapping({ "/explorar-artistas" })
	public String explorarArtistas(Model model, HttpSession sesion ) {
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());

		model.addAttribute("listaObras", obraService.findAllObras());
		model.addAttribute("listaArtistas",artistaService.findAllArtistas());
		model.addAttribute("listaCorrientes",corrienteService.findAllCorriente());
		model.addAttribute("listaNacionalidades",artistaService.findNacionalidades());
		return "explorar-artistas";
	}
	
	@GetMapping({ "/explorar-corrientes" })
	public String explorarMovimientos(Model model, HttpSession sesion ) {
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());

		model.addAttribute("listaObras", obraService.findAllObras());
//		model.addAttribute("listaArtistas",artistaService.findAllArtistas());
		model.addAttribute("listaCorrientes",corrienteService.findAllCorriente());
		return "explorar-corrientes";
	}
	
	@GetMapping({ "/artista-obras" })
	public String explorarArtistaObras(Model model, @RequestParam(name="codArt") String codArt, HttpSession sesion) {
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());

		int cod = Integer.parseInt(codArt);
		
		Artista artistaSelec=artistaService.findByCodArtista(cod);
		model.addAttribute("artistaSelec", artistaSelec);
		model.addAttribute("listaCorrientes",corrienteService.findAllCorriente());
		model.addAttribute("listaObrasArtista", obraService.findByCodArtista(cod));
		model.addAttribute("listaArtistasRel",artistaService.findByCorriente(artistaSelec.getCodCorriente()));
		return "artista-obras";
	}
	@GetMapping({ "/corriente-obras" })
	public String explorarCorrientesObras(Model model, @RequestParam(name="codCorr") String codCorr, HttpSession sesion) {
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());

		int cod = Integer.parseInt(codCorr);
		model.addAttribute("corrienteSelec",corrienteService.findByCodCorriente(cod));
		model.addAttribute("listaObrasCorriente", obraService.findByCodCorriente(cod));
		model.addAttribute("listaArtistasCorr",artistaService.findByCorriente(cod));
		
		return "corriente-obras";
	}

	
}
