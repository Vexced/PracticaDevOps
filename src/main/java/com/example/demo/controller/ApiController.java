package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.List;

@RestController
public class ApiController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hola desde la API!";
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return List.of(
                new User("Axel", "Vergara"),
                new User("Jane", "Doe")
        );
    }
}

@Controller
class UserController {
    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", List.of(
                new User("Axel", "Vergara"),
                new User("Jane", "Doe")
        ));
        return "users";
    }
}
