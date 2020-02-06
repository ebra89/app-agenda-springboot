package com.aton.informatica.appagendaspringboot.controller;

import com.aton.informatica.appagendaspringboot.entities.User;
import com.aton.informatica.appagendaspringboot.services.UserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



import javax.validation.Valid;

@Controller
public class RegisterController {

    // Log log4j example


    final static Logger logger = LogManager.getLogger(RegisterController.class);


    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model ) {

        model.addAttribute("user", new User());
        return "views/registerForm";
    }

    @PostMapping("/registrazione")
    public String registerazioneUser(@Valid User user, BindingResult bindingResult, Model model) {

        // messaggio da recapitare
        logger.error("hai usato questo metodo!!! non andato a buon fine perche non viengono passato tutti informazioni ");


        if(bindingResult.hasErrors()) {
            return "views/registerForm";
        }
        if(userService.userPresente(user.getEmail())) {

            model.addAttribute("esiste", true);
            return "views/registerForm";
        }
        try {
            userService.createUser(user);

            // informazione dopo salvataggio

            logger.error("salvataggio con successo di metodo "+ user.toString());

            return "views/confermaRegistrazione";

        }catch (Exception ex){

            // messaggio di errore
            logger.error(" salvataggio non andato a buon fine "+ex.getMessage());

            ex.printStackTrace();
        }
        return "views/confermaRegistrazione";
    }

}
