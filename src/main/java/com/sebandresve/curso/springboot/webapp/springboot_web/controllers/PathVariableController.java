package com.sebandresve.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sebandresve.curso.springboot.webapp.springboot_web.dto.ParamDto;
import com.sebandresve.curso.springboot.webapp.springboot_web.models.User;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.code}")
    private Integer code;

    @Value("#{'${config.username}'.toUpperCase()}")
    private String username;

    @Value("${config.listOfValues}")
    //private String[] listOfValues;
    private List<String> listOfValues;


    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto params = new ParamDto();
        params.setMessage(message);
        return params;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // hacer algo con el usuario save en la bbdd
        user.setName(user.getName().toUpperCase());
        return user;        
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("code", code);
        json.put("username", username);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        return json;
    }
}
