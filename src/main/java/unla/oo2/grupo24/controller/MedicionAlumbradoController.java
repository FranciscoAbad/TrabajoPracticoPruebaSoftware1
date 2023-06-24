package unla.oo2.grupo24.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import unla.oo2.grupo24.entity.Contenedor;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.entity.alumbradointeligente.AlumbradoInteligente;
import unla.oo2.grupo24.entity.alumbradointeligente.MedicionSensorLuz;
import unla.oo2.grupo24.service.AlumbradoInteligenteService;
import unla.oo2.grupo24.service.MedicionSensorLuzService;
import unla.oo2.grupo24.service.imp.EventoServiceImp;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/medicion-alumbrado")
public class MedicionAlumbradoController {
    @Autowired
    AlumbradoInteligenteService alumbradoInteligenteService;

    @Autowired
    EventoServiceImp serviceEvento;

    @Autowired
    MedicionSensorLuzService medicionSensorLuzService;

    @GetMapping()
    public String form() {
        return "mediciones/medicionAlumbrado";
    }

    @PostMapping()
    public String agregarMedicionContenedor(@RequestParam("fechaHora") LocalDateTime fechaHora, @RequestParam("idDispositivo") int idDispositivo,@RequestParam(value = "lleno", defaultValue = "false") boolean lleno) {

        AlumbradoInteligente alumbradoInteligente = alumbradoInteligenteService.getById(idDispositivo);
        MedicionSensorLuz medicion=new MedicionSensorLuz(fechaHora,alumbradoInteligente,lleno);
        medicionSensorLuzService.add(medicion);
        if(lleno!=alumbradoInteligente.isEncendido()){
            alumbradoInteligente.setEncendido(lleno);
            String descripcion = lleno ? "Luz encendida" : "Luz apagada";
            Evento evento = new Evento(medicion.getFechaHora(), descripcion, alumbradoInteligente);
            serviceEvento.add(evento);
        }
        return "mediciones/medicionAlumbrado";
    }

}
