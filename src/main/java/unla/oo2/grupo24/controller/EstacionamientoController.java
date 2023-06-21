package unla.oo2.grupo24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unla.oo2.grupo24.entity.Dispositivo;
import unla.oo2.grupo24.entity.SensorEstacionamiento;
import unla.oo2.grupo24.entity.User;
import unla.oo2.grupo24.entity.UserRole;
import unla.oo2.grupo24.service.IDispositivoService;
import unla.oo2.grupo24.service.imp.EstacionamientoSevicesImp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class EstacionamientoController {

    @Autowired
    private EstacionamientoSevicesImp service;


    @GetMapping("/estacionamiento")
    public String listarDispositivos(Model model) {

       // SensorEstacionamiento sensorEstacionamiento=new SensorEstacionamiento("nombe","dispositivo",true, LocalDate.now(),true);
       // service.add(sensorEstacionamiento);
        List<SensorEstacionamiento> listado = service.getAll();
        model.addAttribute("lista",listado);

        return "views/dispositivos/listaEstacionamientos";
    }



    @GetMapping("/estacionamiento/create")
    public String formRegistroEstacionamiento(Model model) {

        SensorEstacionamiento sensor=new SensorEstacionamiento();

        model.addAttribute("estacionamiento",sensor);
        return "views/dispositivos/crearEstacionamiento";
    }

    @PostMapping("/estacionamiento")
    public String registerUser( @ModelAttribute("estacionamiento") SensorEstacionamiento estacionamiento,Model model) {




estacionamiento.setFecha(LocalDate.now());
estacionamiento.setActivo(true);
estacionamiento.setEstadoActual(false);

        service.add(estacionamiento);
        System.out.println(estacionamiento);

        List<SensorEstacionamiento> listado = service.getAll();
        model.addAttribute("lista",listado);

        return "views/dispositivos/listaEstacionamientos";
    }
}
