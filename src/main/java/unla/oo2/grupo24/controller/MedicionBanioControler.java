package unla.oo2.grupo24.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import unla.oo2.grupo24.entity.Banio;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.entity.MedicionBanio;
import unla.oo2.grupo24.entity.MedicionEstacionamiento;
import unla.oo2.grupo24.service.IBanioService;
import unla.oo2.grupo24.service.IMedicionBanioService;
import unla.oo2.grupo24.service.imp.BanioServiceImp;
import unla.oo2.grupo24.service.imp.EventoServiceImp;
import unla.oo2.grupo24.service.imp.MedicionBanioImp;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class MedicionBanioControler {

	@Autowired
	BanioServiceImp serviceBanio;
	
	@Autowired
	MedicionBanioImp serviceMedicion;
	
	 @Autowired
	 EventoServiceImp serviceEvento;

	@GetMapping("/medicionesbanio")
	public String formRegistroEstacionamiento(Model model) {

		return "views/dispositivos/medicionbanio";
	}

	@PostMapping("/medicionesbanio")
	public String agregarMedicionEstacionamiento(@RequestParam("fechaHora") LocalDateTime fechaHora,
			@RequestParam("idDispositivo") int idDispositivo,
			@RequestParam(value = "higienizado", defaultValue = "false") boolean higienizado) {

		Banio banio = serviceBanio.buscarId(idDispositivo);

		if(higienizado!=banio.isHigienizado()){

	         
	            banio.setHigienizado(higienizado);
	            MedicionBanio medicion=new MedicionBanio(fechaHora,banio,higienizado);
	      
	            serviceMedicion.add(medicion);


	      
	            String descripcion = higienizado ? "Banio No Higienizado" : "Banio Higienizado";
	            Evento evento = new Evento(medicion.getFechaHora(), descripcion, banio);
	           
	            serviceEvento.add(evento);
	        }

		return "views/dispositivos/medicionbanio";
	}

}
