package com.example.demo.controller;

import com.example.demo.service.FlamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FlamesController {

    @Autowired
    private FlamesService flamesService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String name1,
                             @RequestParam String name2,
                             Model model) {

        String result = flamesService.calculateFlames(name1, name2);
        model.addAttribute("result", result);
        return "index";
    }
}
