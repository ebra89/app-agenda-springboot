package com.aton.informatica.appagendaspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String showPaginaAbout(){
        return "views/about";
    }

}
