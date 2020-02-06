package com.aton.informatica.appagendaspringboot.controller;

import com.aton.informatica.appagendaspringboot.entities.User;
import com.aton.informatica.appagendaspringboot.services.TaskService;
import com.aton.informatica.appagendaspringboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String showProfilePage(Model model, Principal principal) {

        String email = principal.getName();
        User user = userService.findOne(email);
        model.addAttribute("tasks",taskService.findUserTask(user));

        System.out.println(taskService.findUserTask(user));

        return"views/profile1";
    }
}
