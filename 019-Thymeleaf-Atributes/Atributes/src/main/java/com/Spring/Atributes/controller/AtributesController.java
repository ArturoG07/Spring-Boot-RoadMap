package com.Spring.Atributes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AtributesController {
    @GetMapping("/")
    public String goToForm() {
        return "form";
    }
    @PostMapping("/process")
    public String process(@RequestParam String name,
                          @RequestParam int age,
                          Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("isOver18", (age>=18));
        model.addAttribute("email", name +"@example.com");
        return "results";
    }
}
