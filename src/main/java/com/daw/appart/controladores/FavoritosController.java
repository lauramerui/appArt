package com.daw.appart.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.appart.model.Galeria;
import com.daw.appart.model.Obrafav;
import com.daw.appart.model.Obragaleria;
import com.daw.appart.model.Usuario;
import com.daw.appart.service.ArtistaService;
import com.daw.appart.service.GaleriaService;
import com.daw.appart.service.ObraService;
import com.daw.appart.service.ObrafavService;
import com.daw.appart.service.ObragaleriaService;
import com.daw.appart.service.VistaObrafavService;
import com.daw.appart.service.VistagaleriaService;

@Controller
public class FavoritosController {

	@Autowired
	private ObraService obraService;
	@Autowired
	private ArtistaService artistaService;
	@Autowired
	private ObrafavService obrafavService;
	@Autowired
	private VistaObrafavService vistaobrafavService;
	@Autowired
	private VistagaleriaService vistagaleriaService;
	@Autowired
	private GaleriaService galeriaService;
	@Autowired
	private ObragaleriaService obragaleriaService;

	@GetMapping({ "/favoritos" })
	public String explorar(Model model, HttpSession sesion) {
		model.addAttribute("usuLogin", new Usuario());
		model.addAttribute("usuarioReg", new Usuario());

		// obj para nueva galeria
		model.addAttribute("nuevaGaleria", new Galeria());

		if (sesion.getAttribute("usuLogueado") != null) {

			Usuario usu = (Usuario) sesion.getAttribute("usuLogueado");
			String email = usu.getEmail();
			model.addAttribute("listaFavs", vistaobrafavService.findByEmail(email));
			model.addAttribute("listaGalerias", galeriaService.findByEmail(email));
			model.addAttribute("listaVistaGalerias", vistagaleriaService.findByEmail(email));

		}
		return "favoritos";
	}

	// nueva galeria
	@GetMapping("/favoritos/new")
	public String nuevoUsuarioSubmit(@ModelAttribute("nuevaGaleria") Galeria nuevaGaleria, HttpSession sesion) {
		if (sesion.getAttribute("usuLogueado") != null) {
			Usuario usu = (Usuario) sesion.getAttribute("usuLogueado");
			nuevaGaleria.setEmailUsu(usu.getEmail());
			galeriaService.addGaleria(nuevaGaleria);
		}
		return "redirect:/favoritos";
	}

	// eliminar galeria
	@GetMapping("/favoritos/delete")
	public String galeriaDelete(@RequestParam(name = "codGaleria") String codGaleria, HttpSession sesion) {
		if (sesion.getAttribute("usuLogueado") != null) {
			Usuario usu = (Usuario) sesion.getAttribute("usuLogueado");
			int cod = Integer.parseInt(codGaleria);

			Galeria galeria = galeriaService.findByCodgaleria(cod);
			galeriaService.deteleGaleria(galeria);

			List<Obragaleria> listaobras = obragaleriaService.findObragaleriaByCodGaleria(cod);
			listaobras.forEach(obraGaleria -> {
				obragaleriaService.deteleObragaleria(obraGaleria);
			});
		}
		return "redirect:/favoritos";
	}

	// eliminar me gusta desde página favoritos
	@GetMapping("/favoritos/delete/{codObraFav}")
	public String deleteMegusta(@PathVariable("codObraFav") String codObraFav) {
		int cod = 0;
		if (codObraFav != null) {
			cod = Integer.parseInt(codObraFav);
		}
		Obrafav obrafav = obrafavService.findByCodObrafav(cod);
		obrafavService.deteleObrafav(obrafav);
		return "redirect:/favoritos";
	}
	// eliminar obra de galería desde página favoritos
	@GetMapping("/obra-galeria/delete/{codGaleria}/{codObra}")
	public String deleteObraGaleria(@PathVariable("codGaleria") String codGaleria, @PathVariable("codObra") String codObra,HttpServletRequest request) {
		int codGal = 0;
		int codOb=0;
		if (codGaleria != null&&codObra!=null) {
			codGal = Integer.parseInt(codGaleria);
			codOb = Integer.parseInt(codObra);
		}
		Obragaleria obragal = obragaleriaService.findByCodGaleriaAndCodObra(codGal,codOb);
		obragaleriaService.deteleObragaleria(obragal);
//		request.setAttribute("codGaleria", codGal);
		return "redirect:/galeria-obras?codGaleria="+codGal;
	}

	@GetMapping({ "/galeria-obras" })
	public String explorarObra(Model model, @RequestParam(name = "codGaleria") String codGaleria, HttpSession sesion) {
		model.addAttribute("usuLogin", new Usuario());
		model.addAttribute("usuarioReg", new Usuario());

		model.addAttribute("galeria", galeriaService.findByCodgaleria(Integer.parseInt(codGaleria)));
		model.addAttribute("obrasGaleria", vistagaleriaService.findByCodgaleria(Integer.parseInt(codGaleria)));
		return "galeria-obras";
	}
}
