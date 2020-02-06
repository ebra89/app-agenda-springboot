package com.aton.informatica.appagendaspringboot.controller;

import com.aton.informatica.appagendaspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {


    @Autowired
    private UserService userService;

//	@GetMapping("/users")
//	public String listaUsers(Model model) {
//		model.addAttribute("users", userService.findAll());
//		return "views/listaUsers";
//	}

    @GetMapping("/users")
    public String listaUsersNome(Model model, @RequestParam(defaultValue = "")  String nome) {
        model.addAttribute("users",userService.findByNome(nome));
        return "views/listaUsers";
    }

}
