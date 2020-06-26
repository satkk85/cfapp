package com.cakefactory.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping(value = {"/","home"})
    public String home(Model model) {
        model.addAttribute("categories", List.of("Birthday Cake", "Photo Cake", "Square Cake"));
        return "home";
    }
}
