package unla.oo2.grupo24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import unla.oo2.grupo24.service.SensorLuzInteligenteService;

@Controller
public class SensorLuzInteligenteController {
    @Autowired
    SensorLuzInteligenteService LuzInteligenteService;
}
