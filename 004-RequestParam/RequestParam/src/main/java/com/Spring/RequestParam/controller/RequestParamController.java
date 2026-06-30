package com.Spring.RequestParam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * Rest Controller with 2 endpoints that require parameters with the annotation RequestParam
 */
@RestController
public class RequestParamController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return "Hello " + name;
    }
    @GetMapping("/bye")
    public String sayBye(@RequestParam String name,
                         @RequestParam int age,
                         @RequestParam String job) {
        return "Bye " + name + " working as " + job + " at " + age + " years old";
    }
}