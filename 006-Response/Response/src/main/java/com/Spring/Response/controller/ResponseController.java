package com.Spring.Response.controller;

import com.Spring.Response.model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ResponseController {
    /**
     * ResponseBody endpoint
     * @return JSON list with all clients manually added
     */
    @GetMapping("/clients")
    @ResponseBody
    public List<Client> getClients() {

        List<Client> clientList = new ArrayList<Client>();
        clientList.add(new Client(1, "Arturo", "Gregori"));
        clientList.add(new Client(2, "Cristiano", "Ronaldo"));
        clientList.add(new Client(3, "Lionel", "Messi"));

        return clientList;
    }

    /**
     * Response entity endpoint
     * @return A ResponseEntity with a message and a status code
     */
    @GetMapping("/responseentity")
    ResponseEntity<String> getResponse() {
        return new ResponseEntity<>("This is a ResponseEntity test ", HttpStatus.OK);
    }
    /**
     * Response entity endpoint
     * @return A ResponseEntity with a notfound message and Http code
     */
    @GetMapping("/notfoundresponse")
    ResponseEntity<String> notFoundTest() {
        return new ResponseEntity<>("This is a ResponseEntity failed test ", HttpStatus.NOT_FOUND);
    }
}
