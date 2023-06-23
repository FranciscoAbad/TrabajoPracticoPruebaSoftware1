package unla.oo2.grupo24.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.service.imp.DispositivoServiceImp;
import unla.oo2.grupo24.service.imp.EventoServiceImp;

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

    @GetMapping("/eventos/{id}")
    public String eliminarEvento(@PathVariable("id") long id, Model model) {

        service.delete(id);

        model.addAttribute("lista", service.getAll());


        return "eventos/listaEventos";
    }

    @GetMapping("/eventos/{id}/edit")
    public String editarEvento(@PathVariable("id") long id, Model model) {
        Evento evento = service.getById(id);
        model.addAttribute("evento", evento);

        agregarListaDispositivosAlModelo(model);

        return "eventos/editarEvento";
    }

    @PostMapping("/eventos/{id}/update")
    public String actualizarEvento(
            @PathVariable("id") long id,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("fechaHora") LocalDateTime fechaHora,
            @RequestParam("idDispositivo") int idDispositivo,
            Model model
    ) {
        Evento evento = service.getById(id);
        evento.setDescripcion(descripcion);
        evento.setFechaHora(fechaHora);
        evento.setDispositivo(serviceDispositivo.buscarId(idDispositivo));

        service.modify(evento);

        List<Evento> listado = service.getAll();
        model.addAttribute("lista", listado);

        return "eventos/listaEventos";
    }


    private void agregarListaDispositivosAlModelo(Model model) {
        List<Dispositivo> listaDispositivos = serviceDispositivo.listarTodos();
        model.addAttribute("listaDispositivos", listaDispositivos);
    }





}
