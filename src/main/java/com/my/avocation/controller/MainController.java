package com.my.avocation.controller;

import com.my.avocation.Service.CommentService;
import com.my.avocation.entity.Label;
import com.my.avocation.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private LabelRepository labelRepository;

    // Map the "/index" URL to the "user" method

    @Autowired
    private CommentService commentService;


    @GetMapping("/label")
    public String labels(Model model) {
        Label label = labelRepository.findLabelById(1);
        model.addAttribute("label", label);
        return "label";
    }

    @PostMapping("comment")
    public String comment(Model model) {
        commentService.addComment();
        return "comment";
    }
}
