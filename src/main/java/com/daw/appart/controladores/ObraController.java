package com.daw.appart.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.daw.appart.model.Galeria;
import com.daw.appart.model.Obra;
import com.daw.appart.model.Obrafav;
import com.daw.appart.model.Obragaleria;
import com.daw.appart.model.Usuario;
import com.daw.appart.model.Vistagaleria;
import com.daw.appart.service.ArtistaService;
import com.daw.appart.service.GaleriaService;
import com.daw.appart.service.ObraService;
import com.daw.appart.service.ObrafavService;
import com.daw.appart.service.ObragaleriaService;
import com.daw.appart.service.VistagaleriaService;
import com.daw.appart.service.VistaobraService;

@Controller
public class ObraController {
	
	@Autowired
	private	ObraService obraServicio;
	
	@Autowired
	private VistaobraService vistaObraServicio;
	
	@Autowired
	private ArtistaService artistaServicio;
	
	@Autowired
	private GaleriaService galeriaServicio;
	
	@Autowired
	private VistagaleriaService vistaGaleriaServicio;
	
	@Autowired
	private ObrafavService obraFavServicio;
	
	@Autowired
	private ObragaleriaService obraGaleriaServicio;
	
	@GetMapping({ "/obra" })
	public String explorarObra(Model model, @RequestParam(name="codObra") String codObra, HttpSession sesion) {
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());

		int cod = Integer.parseInt(codObra);
		Obra obraEncontrada=obraServicio.findByCodObra(cod);
		model.addAttribute("obraSelec", vistaObraServicio.findByCodObra(cod));
		
		model.addAttribute("existeMegusta",false);
		if(sesion.getAttribute("usuLogueado")!=null) {
			String email = ((Usuario)sesion.getAttribute("usuLogueado")).getEmail();
			//galerias del usuario
			List<Galeria>listaGaleriasUsu=galeriaServicio.findByEmail(email);
			List<Galeria>listaGaleriasDisponible= new ArrayList(listaGaleriasUsu);
//			List<Galeria>listaGaleriasDisponible=new ArrayList<>();
			for(Galeria g: listaGaleriasUsu) {
				//obras dentro de cada galeria del usuario
				int codGal=g.getCodGaleria();
				List<Obragaleria>listaObraGaleriaUsu=obraGaleriaServicio.findObragaleriaByCodGaleria(codGal);
				//comprobación de si la obra a mostrar ya está en alguna galeria del usuario
				for(Obragaleria og: listaObraGaleriaUsu) {
					if(og.getCodObra()==cod) {
						listaGaleriasDisponible.remove(g);
					}
				}

			}
//			List<Vistagaleria>listaVistaGaleriaUsu=vistaGaleriaServicio.findByCodgaleria(cod);

			model.addAttribute("listaGalerias",listaGaleriasDisponible);
			model.addAttribute("existeMegusta",obraFavServicio.checkMegusta(email, cod));
		}
		
		return "obra";
	}
	
	//añadir favorito desde obra
	@GetMapping("/addFav")
	public String addFav(HttpSession sesion,  @RequestParam(name="codObra") String codObra) {
		if(sesion.getAttribute("usuLogueado")!=null) {
			Usuario usu=(Usuario) sesion.getAttribute("usuLogueado");
			boolean existe=obraFavServicio.checkMegusta(usu.getEmail(), Integer.parseInt(codObra));
			if(existe) {
				Obrafav fav=obraFavServicio.findByEmailCodObra(usu.getEmail(), Integer.parseInt(codObra));
				obraFavServicio.deteleObrafav(fav);
			}else {
				Obrafav fav = new Obrafav();
				fav.setCodObra(Integer.parseInt(codObra));
				fav.setEmailUsu(usu.getEmail());
				obraFavServicio.addObra(fav);
			}
		}
		return "redirect:/obra?codObra="+codObra;
	}
	
	//añadir obra a galeria desde obra
    @GetMapping("/addObraGaleria/{codGaleria}/{codObra}")
    public String addObraGaleria(@PathVariable(value="codGaleria") Integer codGaleria, @PathVariable(value="codObra") Integer codObra) {
    	//añadir imagen a la galeria
    	Galeria galeria = galeriaServicio.findByCodgaleria(codGaleria);
    	if(galeria.getImagen()==null) {
    		Obra obra = obraServicio.findByCodObra(codObra);
    		galeria.setImagen(obra.getImagen());
    	}
    	Obragaleria obragal = new Obragaleria();
    	obragal.setCodGaleria(codGaleria);
    	obragal.setCodObra(codObra);

    	obraGaleriaServicio.addObra(obragal);

        return "redirect:/obra?codObra={codObra}";
    }
	

	

}
