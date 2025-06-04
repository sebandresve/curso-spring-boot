package com.sebandresve.curso.springboot.webapp.springboot_web.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sebandresve.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {
        User user = new User("Sebastián", "Vásquez");
        model.addAttribute("title", "Hola Mundo Spring Boot");
        user.setEmail("sebandres.ve@gmail.com");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "Lista de Usuarios");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(new User("Sebastián", "Vásquez", "sebandres.ve@gmail.com"),
                new User("Andrés", "Espinoza"),
                new User("María", "Gonzalez", "cote@gmail.com"),
                new User("José", "Lopez"));
    }

}
