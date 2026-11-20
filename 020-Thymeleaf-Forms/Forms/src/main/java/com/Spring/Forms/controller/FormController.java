package com.Spring.Forms.controller;

import com.Spring.Forms.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @GetMapping("/")
    public String goToForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }
    @PostMapping("/process")
    public String process(User user,
                          Model model) {
        model.addAttribute("user", user);

        user.setEmail(user.getName() + "@example.com");
        user.setIsOver18((user.getAge() >= 18));
        return "results";
    }
}
