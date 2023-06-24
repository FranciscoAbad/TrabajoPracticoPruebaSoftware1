package unla.oo2.grupo24.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import unla.oo2.grupo24.entity.alumbradointeligente.AlumbradoInteligente;
import unla.oo2.grupo24.service.AlumbradoInteligenteService;

@Controller
@RequestMapping("/alumbrado-inteligente")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AlumbradoInteligenteController {
    
    @Autowired
    AlumbradoInteligenteService alumbradoInteligenteService;

    @GetMapping
    public String getAll(Model model) {
        List<AlumbradoInteligente> dispositivos = alumbradoInteligenteService.getAll();
        model.addAttribute("list", dispositivos);
        return "alumbrado-inteligente/listado";
    }

    @GetMapping("/form")
    public String formulario(Model model) {
        AlumbradoInteligente alumbradoInteligente = new AlumbradoInteligente();
        model.addAttribute("alumbradoInteligente", alumbradoInteligente);
        return "alumbrado-inteligente/form";
    }

    @PostMapping
    public String guardarSensor(Model model, @ModelAttribute("sensorluz") AlumbradoInteligente alumbradoInteligente) {
        alumbradoInteligente.setFecha(LocalDate.now());
        alumbradoInteligente.setActivo(true);
        alumbradoInteligenteService.add(alumbradoInteligente);
        return "redirect:/alumbrado-inteligente";
    }

    @GetMapping("/{id}/edit")
    public String formEditarContenedor(@PathVariable("id") long id, Model model) {
        AlumbradoInteligente alumbrado = alumbradoInteligenteService.getById(id);
        model.addAttribute("alumbrado", alumbrado);
        return "alumbrado-inteligente/editar";
    }

    @GetMapping("/{id}")
    public String borraString(@PathVariable("id") long id, Model model) {
        alumbradoInteligenteService.delete(id);
        List<AlumbradoInteligente> dispositivos = alumbradoInteligenteService.getAll();
        model.addAttribute("list", dispositivos);
        return "alumbrado-inteligente/listado";
    }

    @PostMapping("/{id}/update")
    public String actualizarContenedor(@PathVariable("id") long id,
            @ModelAttribute("alumbrado") AlumbradoInteligente alumbrado, Model model) {
        AlumbradoInteligente alumbradoInteligente = alumbradoInteligenteService.getById(id);
        alumbradoInteligente.setNombre(alumbrado.getNombre());
        alumbradoInteligente.setDescripcion(alumbrado.getDescripcion());
        alumbradoInteligente.setActivo(alumbrado.isEncendido());
        alumbradoInteligenteService.modify(alumbradoInteligente);
        List<AlumbradoInteligente> dispositivos = alumbradoInteligenteService.getAll();
        model.addAttribute("list", dispositivos);
        return "alumbrado-inteligente/listado";
    }

}
