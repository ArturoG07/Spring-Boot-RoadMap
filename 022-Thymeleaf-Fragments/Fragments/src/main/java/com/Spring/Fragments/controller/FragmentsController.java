package com.Spring.Fragments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {
    @GetMapping("/")
    public String goToMain() {
        return "main";
    }
}
