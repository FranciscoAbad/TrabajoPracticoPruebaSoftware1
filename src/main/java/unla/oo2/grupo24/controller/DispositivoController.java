package unla.oo2.grupo24.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import unla.oo2.grupo24.Entity.Dispositivo;
import unla.oo2.grupo24.Service.IDispositivoService;


@Controller
@RequestMapping("/views/dispositivos")
public class DispositivoController {
	
	
	@Autowired
	private IDispositivoService service;
	
	@GetMapping("/lista")
	public String listarDispositivos(Model model) {
		List<Dispositivo> listado = service.listarTodos();
		model.addAttribute("lista",listado);
		return "/views/dispositivos/listar";
	}
	
	

}