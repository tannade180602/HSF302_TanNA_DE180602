package com.de180602.mvc.controller;

import com.de180602.mvc.service.ShoesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoesController {

    private final ShoesService shoesService;

    public ShoesController(ShoesService shoesService) {
        this.shoesService = shoesService;
    }

    @GetMapping("/")
    public String list(@RequestParam(value = "shoesName", required = false) String shoesName, Model model) {
        if (shoesName != null && !shoesName.isEmpty()) {
            model.addAttribute("shoesList", shoesService.search(shoesName));
            model.addAttribute("shoesName", shoesName); // To keep search input
        } else {
            model.addAttribute("shoesList", shoesService.getAll());
        }
        return "list";
    }
}
