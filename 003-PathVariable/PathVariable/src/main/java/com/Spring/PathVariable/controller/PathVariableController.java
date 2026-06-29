package com.Spring.PathVariable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the path variable application with parameters on the Path
 */
@RestController
public class PathVariableController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/bye/{name}/{age}/{job}")
    public String sayBye(@PathVariable String name,
                         @PathVariable int age,
                         @PathVariable String job) {
        return "Bye " + name + " working as " + job + " at " + age + " years old";
    }
}
