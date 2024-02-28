package com.my.avocation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    // Map the "/index" URL to the "user" method
    @GetMapping("/index")
    public String user(Model model){
        // Add a "name" attribute to the model with a value of "test"
        model.addAttribute("name","test");
        // Return the "index" view
        return  "index";
    }

    @GetMapping("/user")
    public String users(Model model){
        return "user";
    }
}
