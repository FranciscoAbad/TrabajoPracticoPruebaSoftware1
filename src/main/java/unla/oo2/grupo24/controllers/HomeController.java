package unla.oo2.grupo24.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import unla.oo2.grupo24.helpers.ViewRouteHelper;


@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/home")
    public ModelAndView index() {
        ModelAndView page = new ModelAndView(ViewRouteHelper.INDEX);
        return page;
    }

    @GetMapping("/")
    public RedirectView redirectToHomeIndex(){
        return new RedirectView(ViewRouteHelper.INDEX);
    }
}