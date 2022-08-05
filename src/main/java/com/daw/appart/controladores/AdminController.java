package com.daw.appart.controladores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.daw.appart.model.Artista;
import com.daw.appart.model.Corriente;
import com.daw.appart.model.Obra;
import com.daw.appart.model.Obrafav;
import com.daw.appart.model.Usuario;
import com.daw.appart.service.ArtistaService;
import com.daw.appart.service.CorrienteService;
import com.daw.appart.service.GaleriaService;
import com.daw.appart.service.ObraService;
import com.daw.appart.service.ObrafavService;
import com.daw.appart.service.PuntuacionService;
import com.daw.appart.service.UsuarioService;
import com.daw.appart.service.VistaObrafavService;
import com.daw.appart.service.VistaobraService;

@Controller
public class AdminController {

	@Autowired
	ServletContext servletContext;

	@Autowired
	private UsuarioService usuarioServicio;

	@Autowired
	private ObraService obraServicio;

	@Autowired
	private VistaobraService vistaobraServicio;

	@Autowired
	private ArtistaService artistaServicio;

	@Autowired
	private GaleriaService galeriaServicio;

	@Autowired
	private CorrienteService corrienteServicio;

	@Autowired
	private ObrafavService obrafavServicio;

	@Autowired
	private VistaObrafavService vistaobrafavServicio;

	@Autowired
	private PuntuacionService puntuacionServicio;

	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("usuLogin", new Usuario());
		model.addAttribute("usuarioReg", new Usuario());

		model.addAttribute("cantUsuarios", usuarioServicio.findAllUser().size());
		model.addAttribute("cantObras", obraServicio.findAllObras().size());
		model.addAttribute("cantArtistas", artistaServicio.findAllArtistas().size());
		model.addAttribute("cantGalerias", galeriaServicio.findAllGaleria().size());
		model.addAttribute("cantCorrientes", corrienteServicio.findAllCorriente().size());
		model.addAttribute("cantObrasfav", obrafavServicio.findAllObrasfav().size());
		model.addAttribute("listaObrasFav", vistaobrafavServicio.countObrasFav());
		model.addAttribute("listaPuntuaciones", puntuacionServicio.findAllPuntuacion());

		return "admin";
	}

	//------------ GESTIÓN OBRAS--------------------------
	@GetMapping({ "/admin-obras" })
	public String adminObras(Model model, HttpSession sesion) {
		model.addAttribute("usuLogin", new Usuario());
		model.addAttribute("usuarioReg", new Usuario());

		model.addAttribute("listaObras", vistaobraServicio.findAllVistaobras());
		return "admin-obras";
	}

	// edita obra
	@GetMapping("/admin-obras/{codObra}")
	public String editObra(@PathVariable("codObra") String codObra, Model model) {
		model.addAttribute("usuLogin", new Usuario());
		model.addAttribute("usuarioReg", new Usuario());

		if (!codObra.equals("{codObra}")) {
			int cod = Integer.parseInt(codObra);
			Obra obraEdit = obraServicio.findByCodObra(cod);
			model.addAttribute("obra", obraEdit);
			model.addAttribute("autor", artistaServicio.findByCodArtista(obraEdit.getCodArtista()));
			model.addAttribute("corriente", corrienteServicio.findByCodCorriente(obraEdit.getCodCorriente()));
		} else {
			model.addAttribute("obra", new Obra());
		}

		model.addAttribute("listaArtistas", artistaServicio.findAllArtistas());
		model.addAttribute("listaCorrientes", corrienteServicio.findAllCorriente());
		return "admin-obras-edit";
	}

	// editar/nueva obra
	@PostMapping({ "/admin-obras/edit" })
	public String editObraSubmit(@ModelAttribute("obra") Obra obra, @RequestParam("fileEdit") MultipartFile fileEdit) {
		if (!fileEdit.isEmpty()&&!fileEdit.equals("")) {
			String ruta = "\\static\\img\\obras";
//			String nombreUnico=UUID.randomUUID()+" "+fileEdit.getOriginalFilename();
			String nombreUnico = obra.getCodObra() + fileEdit.getOriginalFilename();

			try {
				byte[] bytes = fileEdit.getBytes();
				String filePath = new File("src/main/resources/static/img/obras").getAbsolutePath() + "\\"
						+ nombreUnico;
				FileOutputStream output = new FileOutputStream(filePath);
				output.write(bytes);
				obra.setImagen(nombreUnico);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {

			if(obra.getImagen().equals("")){
				obra.setImagen("obras-de-arte.jpg");
			}
		}
		obraServicio.editObra(obra);

		return "redirect:/admin-obras";
	}

	// eliminar obra
	@GetMapping("/admin-obras/delete/{codObra}")
	public String deleteObra(@PathVariable("codObra") String codObra) {
		obraServicio.deteleObra(obraServicio.findByCodObra(Integer.parseInt(codObra)));
		return "redirect:/admin-obras";
	}
	
	//-------------GESTIÓN ARTISTAS-----------------------
	@GetMapping({ "/admin-artistas" })
	public String adminArtistas(Model model, HttpSession sesion) {
		model.addAttribute("usuLogin", new Usuario());
		model.addAttribute("usuarioReg", new Usuario());

		model.addAttribute("listaArtistas", artistaServicio.findAllArtistas());
		model.addAttribute("listaCorrientes", corrienteServicio.findAllCorriente());
		return "admin-artistas";
	}

	// edita artista form
	@GetMapping("/admin-artistas/{codArtista}")
	public String editArtista(@PathVariable("codArtista") String codArtista, Model model) {
		model.addAttribute("usuLogin", new Usuario());
		model.addAttribute("usuarioReg", new Usuario());

		if (!codArtista.equals("{codArtista}")) {
			int cod = Integer.parseInt(codArtista);
			Artista artistaEdit = artistaServicio.findByCodArtista(cod);
			model.addAttribute("artista", artistaEdit);
			model.addAttribute("corriente", corrienteServicio.findByCodCorriente(artistaEdit.getCodCorriente()));
		} else {
			model.addAttribute("artista", new Artista());
		}

		model.addAttribute("listaArtistas", artistaServicio.findAllArtistas());
		model.addAttribute("listaCorrientes", corrienteServicio.findAllCorriente());
		return "admin-artistas-edit";
	}

	// editar/nueva artista submit
	@PostMapping({ "/admin-artistas/edit" })
	public String editArtistaSubmit(@ModelAttribute("artista") Artista artista, @RequestParam("fileEdit") MultipartFile fileEdit) {
		if (!fileEdit.isEmpty()) {
			String ruta = "\\static\\img\\artistas";
//			String nombreUnico=UUID.randomUUID()+" "+fileEdit.getOriginalFilename();
			String nombreUnico = artista.getCodArtista() + fileEdit.getOriginalFilename();

			try {
				byte[] bytes = fileEdit.getBytes();
				String filePath = new File("src/main/resources/static/img/artistas").getAbsolutePath() + "\\"
						+ nombreUnico;
				FileOutputStream output = new FileOutputStream(filePath);
				output.write(bytes);
				artista.setImagen(nombreUnico);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {

			if(artista.getImagen().equals("")){
				artista.setImagen("user.png");
			}
		}
		artistaServicio.editArtista(artista);

		return "redirect:/admin-artistas";
	}

	// eliminar artista
	@GetMapping("/admin-artistas/delete/{codArtista}")
	public String deleteArtista(@PathVariable("codArtista") String codArtista) {
		artistaServicio.deteleArtista(artistaServicio.findByCodArtista(Integer.parseInt(codArtista)));
		return "redirect:/admin-artistas";
	}
	
	//--------------	GESTIÓN CORRIENTES ----------------------
	@GetMapping({ "/admin-corrientes" })
	public String adminCorrientes(Model model, HttpSession sesion) {
		model.addAttribute("usuLogin", new Usuario());
		model.addAttribute("usuarioReg", new Usuario());

		model.addAttribute("listaCorrientes", corrienteServicio.findAllCorriente());
		return "admin-corrientes";
	}
	
	// edita corriente
	@GetMapping("/admin-corrientes/{codCorr}")
	public String editCorriente(@PathVariable("codCorr") String codCorr, Model model) {
		model.addAttribute("usuLogin", new Usuario());
		model.addAttribute("usuarioReg", new Usuario());

		if (!codCorr.equals("{codCorr}")) {
			int cod = Integer.parseInt(codCorr);
			Corriente corrEdit = corrienteServicio.findByCodCorriente(cod);
			model.addAttribute("corriente", corrEdit);
		} else {
			model.addAttribute("corriente", new Corriente());
		}

		return "admin-corrientes-edit";
	}
	
	// editar/nueva corriente
	@PostMapping({ "/admin-corrientes/edit" })
	public String editCorrSubmit(@ModelAttribute("corriente") Corriente corriente, @RequestParam("fileEdit") MultipartFile fileEdit) {
		if (!fileEdit.isEmpty()) {
			String ruta = "\\static\\img\\corrientes";
//			String nombreUnico=UUID.randomUUID()+" "+fileEdit.getOriginalFilename();
			String nombreUnico = corriente.getCodCorriente() + fileEdit.getOriginalFilename();

			try {
				byte[] bytes = fileEdit.getBytes();
				String filePath = new File("src/main/resources/static/img/corrientes").getAbsolutePath() + "\\"
						+ nombreUnico;
				FileOutputStream output = new FileOutputStream(filePath);
				output.write(bytes);
				corriente.setImagen(nombreUnico);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {

			if(corriente.getImagen().equals("")){
				corriente.setImagen("corriente.png");
			}
		}

		corrienteServicio.editCorriente(corriente);

		return "redirect:/admin-corrientes";
	}
	
	// eliminar corriente
	@GetMapping("/admin-corrientes/delete/{codCorr}")
	public String deleteCorr(@PathVariable("codCorr") String codCorr) {
		corrienteServicio.deteleCorriente(corrienteServicio.findByCodCorriente(Integer.parseInt(codCorr)));
		return "redirect:/admin-corrientes";
	}

	//------------- GESTIÓN USUARIOS--------------------------------
	@GetMapping({ "/admin-usuarios" })
	public String adminUsuarios(Model model, HttpSession sesion) {
		model.addAttribute("usuLogin", new Usuario());
		model.addAttribute("usuarioReg", new Usuario());

		model.addAttribute("listaUsuarios", usuarioServicio.findAllUser());
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("usuarioEdit", new Usuario());
		return "admin-usuarios";
	}

	// añadir usuario
	@PostMapping("/admin-usuarios/new")
	public String nuevoUsuarioSubmit(@ModelAttribute("usuarioForm") Usuario nuevoUsu,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			String ruta = "C:\\Users\\Laura\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\appArt\\src\\main\\resources\\static\\img\\usuarios";

			try {
				byte[] bytes = file.getBytes();
				Path rutaAbsoluta = Paths.get(ruta + "\\" + file.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				nuevoUsu.setFoto(file.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			nuevoUsu.setFoto("user.png");
		}
		nuevoUsu.setFechaCreacion(LocalDate.now());
		usuarioServicio.addUser(nuevoUsu);
		return "redirect:/admin-usuarios";
	}

	// editar usuario
	@PostMapping({ "/admin-usuarios/edit" })
	public String editUsuarioSubmit(@RequestParam("fileEdit") MultipartFile fileEdit,
			@RequestParam(name = "email") String email, @RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "apellidos") String apellidos, @RequestParam(name = "password") String password,
			@RequestParam(name = "admin") String admin) {

		Usuario usuarioEdit = usuarioServicio.findByEmail(email);

		if (!fileEdit.isEmpty()) {
			String ruta = "C:\\Users\\Laura\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\appArt\\src\\main\\resources\\static\\img\\usuarios";

			try {
				byte[] bytes = fileEdit.getBytes();
				Path rutaAbsoluta = Paths.get(ruta + "\\" + fileEdit.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				usuarioEdit.setFoto(fileEdit.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		usuarioEdit.setNombre(nombre);
		usuarioEdit.setApellidos(apellidos);
		usuarioEdit.setPassword(password);
		usuarioEdit.setAdmin(admin.equals("1") ? true : false);

		usuarioServicio.editUser(usuarioEdit);
		return "redirect:/admin-usuarios";
	}

	// eliminar usuario
	@GetMapping("/admin-usuarios/delete/{emailDel}")
	public String deleteUsu(@PathVariable("emailDel") String emailDel) {
		System.out.println("elminar usuario");
		usuarioServicio.deteleUser(usuarioServicio.findByEmail(emailDel));
		return "redirect:/admin-usuarios";
	}

}
