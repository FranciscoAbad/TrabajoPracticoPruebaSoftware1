package unla.oo2.grupo24.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import unla.oo2.grupo24.entity.alumbradointeligente.AlumbradoInteligente;
import unla.oo2.grupo24.service.AlumbradoInteligenteService;

@Controller
@RequestMapping("/alumbrado-inteligente")
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
}
