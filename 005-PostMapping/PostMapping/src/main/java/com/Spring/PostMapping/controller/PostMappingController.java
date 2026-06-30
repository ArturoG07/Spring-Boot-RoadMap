package com.Spring.PostMapping.controller;

import com.Spring.PostMapping.model.Client;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketOption;

/**
 * Rest controller for the post mapping application with a post mapping endpoint that creates a client
 * tested with PostMan
 */
@RestController
public class PostMappingController {

    @PostMapping("/client")
    public void createClient(@RequestBody Client cli) {
        System.out.println("Client created");
        System.out.println("Name: " + cli.getName());
        System.out.println("Surname: " + cli.getSurname());
    }
}
