package unla.oo2.grupo24.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import unla.oo2.grupo24.entity.Banio;

import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.service.IDispositivoService;

@Controller
@RequestMapping("/banios")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class BanioController {
	
	@Autowired
	private IDispositivoService service;
	
	@GetMapping("/lista")
	public String listarDispositivos(Model model) {
		List<Dispositivo> listado = service.listarTodos();
		model.addAttribute("lista",listado);
		return "views/dispositivos/listar";
	}
	
	@GetMapping("/crear")
	public String mostrarFormulario(Model model) {
		Banio b = new Banio();
		model.addAttribute("banio",b);
		return "views/dispositivos/crear";
	}
	
	@PostMapping("/crear")
	public String crearDispositivos(@ModelAttribute("banio") Banio dispositivo) {
		dispositivo.setActivo(true);

		service.guardarDispositivo(dispositivo);
		
		return "redirect:/banios/lista";
	}
	
	@GetMapping("/eliminar/{id}")
	public String borrarDispositivo(@PathVariable("id") Long id,Model model) {
		service.eliminar(id);
		model.addAttribute("lista",service.listarTodos());
		return "redirect:/banios/lista";
		
	}
	

}
