package com.Spring.HelloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for the HelloWorld application
 */
@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }
}
