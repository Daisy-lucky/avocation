package com.my.avocation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/info")
    public String info(Model model) {
        String img = "/1.jpg";
        model.addAttribute("img",img);
        return "comment";
    }
}
