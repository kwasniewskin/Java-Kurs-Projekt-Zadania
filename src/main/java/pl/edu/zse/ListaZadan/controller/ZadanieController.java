package pl.edu.zse.ListaZadan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.zse.ListaZadan.model.Zadanie;
import pl.edu.zse.ListaZadan.service.ZadanieService;

@Controller
public class ZadanieController {

    private final ZadanieService zadanieService;

    @Autowired
    public ZadanieController(ZadanieService zadanieService) {
        this.zadanieService = zadanieService;
    }


    @RequestMapping(path = "/remove/{id}")
    public String removeZadanie(@PathVariable Long id) {
        zadanieService.removeZadanieById(id);
        return "redirect:/";
    }

    @GetMapping(path = "/add")
    public String addZadanie(Model model) {
        model.addAttribute("zadanie", new Zadanie());
        return "add";
    }

    @PostMapping(path = "/add")
    public String addZadaniePost(@ModelAttribute Zadanie zadanie) {
        zadanieService.addZadanie(zadanie);
        return "redirect:/";
    }

    @GetMapping(path = "/edit/{id}")
    public String editZadanie(@PathVariable Long id, Model model){
        model.addAttribute("zadanie",zadanieService.getZadanieById(id));
        return "edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String editZadaniePost(@PathVariable Long id,
                                  @ModelAttribute("zadanie") Zadanie zadanie){
        Zadanie existingZadanie = zadanieService.getZadanieById(id);
        existingZadanie.setId(id);
        existingZadanie.setTresc(zadanie.getTresc());

        zadanieService.editZadanie(existingZadanie);
        return "redirect:/";
    }

}