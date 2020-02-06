package com.aton.informatica.appagendaspringboot.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {


    @GetMapping("/")
    public String showIndex() {
    return "index";
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "views/loginForm";
    }


}
