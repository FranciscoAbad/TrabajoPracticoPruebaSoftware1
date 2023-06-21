package unla.oo2.grupo24.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import unla.oo2.grupo24.entity.Banio;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.entity.MedicionBanio;
import unla.oo2.grupo24.service.IBanioService;
import unla.oo2.grupo24.service.IMedicionBanioService;
import unla.oo2.grupo24.service.imp.BanioServiceImp;
import unla.oo2.grupo24.service.imp.MedicionBanioImp;

@Controller
public class MedicionBanioControler {

	@Autowired
	IBanioService serviceBanio;
	
	@Autowired
	IMedicionBanioService serviceMedicion;

	@GetMapping("/medicionesbanio")
	public String formRegistroEstacionamiento(Model model) {

		return "views/dispositivos/medicionbanio";
	}

	@PostMapping("/medicionesbanio")
	public String agregarMedicionEstacionamiento(@RequestParam("fechaHora") LocalDateTime fechaHora,
			@RequestParam("idDispositivo") int idDispositivo,
			@RequestParam(value = "higienizado", defaultValue = "false") boolean higienizado) {

		Banio banio = serviceBanio.buscarId(idDispositivo);

		banio.setHigienizado(higienizado);
		MedicionBanio medicion = new MedicionBanio(fechaHora, banio, higienizado);
		serviceMedicion.add(medicion);

		return "views/dispositivos/medicionbanio";
	}

}
