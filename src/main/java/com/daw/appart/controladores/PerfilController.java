package com.daw.appart.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.daw.appart.model.Usuario;
import com.daw.appart.service.UsuarioService;

@Controller
public class PerfilController {
	
	@Autowired
	private	UsuarioService usuarioServicio;
	
	@GetMapping({"/perfil"})
	public String perfil(Model model, HttpSession sesion){
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());
		
		return "perfil";
	}
	
	// Cambiar imagen
	@PostMapping({ "/perfil/cambiar-img" })
	public String editPerfilImg(@RequestParam("fileEdit") MultipartFile fileEdit,HttpSession sesion){
		Usuario usuarioEdit = (Usuario) sesion.getAttribute("usuLogueado");
		if (!fileEdit.isEmpty()) {
			String ruta = "C:\\Users\\Laura\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\appArt\\src\\main\\resources\\static\\img\\usuarios";
			try {
				byte[] bytes = fileEdit.getBytes();
				Path rutaAbsoluta = Paths.get(ruta + "\\" + fileEdit.getOriginalFilename());
				Files.write(rutaAbsoluta, bytes);
				usuarioEdit.setFoto(fileEdit.getOriginalFilename());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		usuarioServicio.editUser(usuarioEdit);
		return "redirect:/perfil";
	}
	
	@PostMapping({"/perfil/cambiar-pass"})
	public String editPerfilPass(@RequestParam("nuevaPassw") String nuevaPassw, HttpSession sesion) {
		Usuario usu = (Usuario) sesion.getAttribute("usuLogueado");
		usu.setPassword(nuevaPassw);
		usuarioServicio.editUser(usu);
		return "redirect:/perfil";
	}
	
	@GetMapping({"/perfil/delete"})
	public String deletePerfil(HttpSession sesion) {
		Usuario usu = (Usuario) sesion.getAttribute("usuLogueado");
		sesion.invalidate();
		usuarioServicio.deteleUser(usu);
		
		return "redirect:/index";
	}
	

}
