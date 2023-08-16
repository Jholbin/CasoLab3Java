package com.example.cibertec.CL3.CasoLab3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros";
    }
}
