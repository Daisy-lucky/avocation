package com.my.avocation.controller;

import com.my.avocation.utils.JWTUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/info")
    public String info(Model model) {
        String img = "/1.jpg";
        model.addAttribute("img",img);
        return "comment";
    }

    @PostMapping("/dologin")
    public String login(Model model,String username){
        Map<String,String> map = new HashMap<>();
        map.put("username","1");
        if (username == "1"){
            String token =JWTUtils.getToken(map);
            model.addAttribute(token);
            return "redirect:/info";
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/loginx")
    public String loginx(){
        return "login";
    }
}
