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


        List<Evento> listado = service.getAll();
        model.addAttribute("lista",listado);


        agregarListaDispositivosAlModelo(model);
        return "eventos/listaEventos";
    }
/*
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
    }*/

    @PostMapping("/eventos/filtrar")
    public String filtrarEventos(@RequestParam(value = "dispositivoId", required = false) Integer dispositivoId, Model model) {
        List<Evento> listado;

        if (dispositivoId != null) {
            // Realiza la filtración de eventos por dispositivo
            listado = service.filtrarPorDispositivo(dispositivoId);
        } else {
            // Si no se selecciona ningún dispositivo, obtén todos los eventos
            listado = service.getAll();
        }

        model.addAttribute("lista", listado);
        agregarListaDispositivosAlModelo(model);

        return "eventos/listaEventos";
    }

    private void agregarListaDispositivosAlModelo(Model model) {
        List<Dispositivo> listaDispositivos = serviceDispositivo.listarTodos();
        model.addAttribute("listaDispositivos", listaDispositivos);
    }

}
