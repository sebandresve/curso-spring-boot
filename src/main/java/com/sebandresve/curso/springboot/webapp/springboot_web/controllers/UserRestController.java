package com.sebandresve.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebandresve.curso.springboot.webapp.springboot_web.dto.UserDto;
import com.sebandresve.curso.springboot.webapp.springboot_web.models.User;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details() {
        User user = new User("Sebastián", "Vásquez");
        UserDto userDto = new UserDto();
        userDto.setTitle("Hola Mundo Spring Boot");
        userDto.setUser(user);
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user = new User("Sebastián", "Vásquez");
        User user2 = new User("Bastián", "Gonzalez");
        User user3 = new User("Nicole", "Vásquez");
        // List<User> users = Arrays.asList(user, user2, user3);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        return users;
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap() {
        User user = new User("Sebastián", "Vásquez");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);
        return body;
    }

}
