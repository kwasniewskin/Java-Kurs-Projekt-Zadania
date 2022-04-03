package pl.edu.zse.ListaZadan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.zse.ListaZadan.service.ZadanieService;

@Controller
public class MainController {

    private final ZadanieService zadanieService;

    @Autowired
    public MainController(ZadanieService zadanieService) {
        this.zadanieService = zadanieService;
    }

    @RequestMapping(path = "/")
    public String mainPage(Model model) {
        model.addAttribute("zadania", zadanieService.getAllZadania());
        return "index";
    }

}
