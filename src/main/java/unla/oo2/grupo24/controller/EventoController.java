package unla.oo2.grupo24.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.entity.SensorEstacionamiento;
import unla.oo2.grupo24.service.imp.DispositivoServiceImp;
import unla.oo2.grupo24.service.imp.EstacionamientoSevicesImp;
import unla.oo2.grupo24.service.imp.EventoServiceImp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventoController {
    @Autowired
    private EventoServiceImp service;


    @Autowired
    private DispositivoServiceImp serviceDispositivo;


    @GetMapping("/eventos")
    public String listarEventos(Model model) {


       // Evento evento=new Evento(LocalDateTime.now(),"eventoo",serviceDispositivo.buscarId(1));
       // System.out.println(serviceDispositivo.buscarId(1));
//service.add(evento);

        List<Evento> listado = service.getAll();
        model.addAttribute("lista",listado);


        return "eventos/listaEventos";
    }

    @GetMapping("/eventos/create")
    public String formRegistroEvento(Model model) {


        return "eventos/crearEvento";
    }

    @PostMapping("/eventos")
    public String registrarEvento(@RequestParam("descripcion") String descripcion , @RequestParam("fechaHora") LocalDateTime fechaHora, @RequestParam("idDispositivo") int idDispositivo,Model model) {


Evento evento=new Evento(fechaHora,descripcion,serviceDispositivo.buscarId(idDispositivo));
System.out.println(evento);

        service.add(evento);


        List<Evento> listado = service.getAll();
        model.addAttribute("lista",listado);


        return "eventos/listaEventos";
    }

}
