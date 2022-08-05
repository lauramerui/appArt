package com.daw.appart.controladores;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.daw.appart.model.Usuario;
import com.daw.appart.service.ObraService;
import com.daw.appart.service.UsuarioService;

@Controller
public class IndexController {
	
	@Autowired
	private	UsuarioService servicio;
	
	@Autowired
	private ObraService obraServicio;
	
	@GetMapping({"/","/index"})
	public String loginRegistro(Model model, HttpSession sesion){
		model.addAttribute("usuLogin",new Usuario());
		model.addAttribute("usuarioReg",new Usuario());
		
		model.addAttribute("obraAleat",obraServicio.obraAleatoria());
		return "index";
	}
	
	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute("usuLogin") Usuario usuario, HttpSession sesion, Model model) {
		Usuario usuLogueado = servicio.login(usuario.getEmail(),usuario.getPassword());
		System.out.println("usuario logueado: " + usuLogueado);
		if(usuLogueado!=null) {
			sesion.setAttribute("usuLogueado", usuLogueado);
			return "redirect:/";
		}else {
			System.out.println("Usuario no existe o contraseña incorrecta.");
			return "redirect:/";
		}
	}
	@GetMapping("/logout")
	public String cerrarSesion(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/registro")
	public String registroSubmit(@ModelAttribute("usuarioReg") Usuario nuevoUsu,HttpSession sesion) {
		nuevoUsu.setFoto("user.png");
		nuevoUsu.setFechaCreacion(LocalDate.now());
		servicio.addUser(nuevoUsu);
		sesion.setAttribute("usuLogueado",nuevoUsu);
		return "redirect:/";
	}
	
}
