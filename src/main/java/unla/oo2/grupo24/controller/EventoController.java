package unla.oo2.grupo24.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.entity.SensorEstacionamiento;
import unla.oo2.grupo24.service.imp.EstacionamientoSevicesImp;
import unla.oo2.grupo24.service.imp.EventoServiceImp;

import java.time.LocalDate;
import java.util.List;

@Controller
public class EventoController {
    @Autowired
    private EventoServiceImp service;


    @GetMapping("/eventos")
    public String listarEventos(Model model) {


        List<Evento> listado = service.getAll();
        model.addAttribute("lista",listado);


        return "eventos/listaEventos";
    }

    @GetMapping("/evento/create")
    public String formRegistroEvento(Model model) {

        Evento evento=new Evento();

        model.addAttribute("evento",evento);
        return "/evento/crearEvento";
    }

    @PostMapping("/evento")
    public String registrarEvento(@ModelAttribute("evento") Evento evento,Model model) {





        service.add(evento);


        List<Evento> listado = service.getAll();
        model.addAttribute("lista",listado);


        return "/evento/listaEventos";
    }

}
