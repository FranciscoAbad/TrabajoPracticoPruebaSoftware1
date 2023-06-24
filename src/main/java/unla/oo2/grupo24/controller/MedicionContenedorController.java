package unla.oo2.grupo24.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unla.oo2.grupo24.entity.Contenedor;
import unla.oo2.grupo24.entity.Evento;
import unla.oo2.grupo24.entity.MedicionContenedor;
import unla.oo2.grupo24.service.imp.ContenedorServiceImp;
import unla.oo2.grupo24.service.imp.EventoServiceImp;
import unla.oo2.grupo24.service.imp.MedicionContenedorServiceImp;


import java.time.LocalDateTime;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class MedicionContenedorController {

    @Autowired
    ContenedorServiceImp serviceContenedor;

    @Autowired
    EventoServiceImp serviceEvento;

    @Autowired
    MedicionContenedorServiceImp serviceMedicionContenedor;

    @GetMapping("/medicioncontenedor")
    public String formRegistroContenedor(Model model) {


        return "mediciones/medicionContenedor";
    }


    @PostMapping("/medicioncontenedor")
    public String agregarMedicionContenedor(@RequestParam("fechaHora") LocalDateTime fechaHora, @RequestParam("idDispositivo") int idDispositivo,@RequestParam(value = "lleno", defaultValue = "false") boolean lleno) {

        Contenedor contenedor=serviceContenedor.getById(idDispositivo);
        MedicionContenedor medicion=new MedicionContenedor(fechaHora,contenedor,lleno);
        serviceMedicionContenedor.add(medicion);
        if(lleno!=contenedor.isLleno()){

            contenedor.setLleno(lleno);




            String descripcion = lleno ? "Contenedor lleno" : "Contenedor vacio";
            Evento evento = new Evento(medicion.getFechaHora(), descripcion, contenedor);
            serviceEvento.add(evento);
        }

        return "mediciones/medicionContenedor";
    }
}