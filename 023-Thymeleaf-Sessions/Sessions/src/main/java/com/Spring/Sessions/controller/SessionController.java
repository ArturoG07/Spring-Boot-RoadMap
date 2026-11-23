package com.Spring.Sessions.controller;

import com.Spring.Sessions.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SessionController {
    @GetMapping("/")
    public String goToMain() {
        return "main";
    }

    @PostMapping("/login")
    public String login(HttpSession session,
                        Model model,
                        @RequestParam String name,
                        @RequestParam String password) {
        List<User> users = List.of(
                new User("User1", "1234"),
                new User("User2", "verybadpassword"),
                new User("User3", "password")
        );

        boolean correctLogin = false;

        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getName().equals(name) && users.get(i).getPassword().equals(password)) {
                correctLogin = true;
                break;
            }
        }

        if (correctLogin) {
            session.setAttribute("user", name);
        } else {
            model.addAttribute("error", "Incorrect login");
        }
        return "login";
    }

}
