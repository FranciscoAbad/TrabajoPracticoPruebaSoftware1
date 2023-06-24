package unla.oo2.grupo24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unla.oo2.grupo24.entity.Contenedor;
import unla.oo2.grupo24.service.imp.ContenedorServiceImp;

import java.time.LocalDate;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ContenedorController {

    @Autowired
    private ContenedorServiceImp service;

    @GetMapping("/contenedor")
    public String listarContenedores(Model model){

      //  Contenedor contenedor=new Contenedor("nombre","descripcion",true, LocalDate.now(),true,"asf","asf");
       // service.add(contenedor);
        model.addAttribute("lista",service.getAll());

        return "views/dispositivos/listarContenedor";

    }

    @GetMapping("/contenedor/create")
    public String formRegistroContenedor(Model model){

        Contenedor contenedor= new Contenedor();

        model.addAttribute("contenedor",contenedor);

        return "views/dispositivos/crearContenedor";
    }

    @PostMapping("/contenedor")
    public String registerUser(@ModelAttribute("contenedor") Contenedor contenedor,Model model){


        contenedor.setFecha(LocalDate.now());
        contenedor.setActivo(true);

        service.add(contenedor);

        model.addAttribute("lista",service.getAll());


        return "views/dispositivos/listarContenedor";
    }

    @GetMapping("/contenedor/{id}")
    public String eliminarContenedor(@PathVariable("id") long id, Model model) {

            service.delete(id);

        model.addAttribute("lista", service.getAll());


        return "views/dispositivos/listarContenedor";
    }

}