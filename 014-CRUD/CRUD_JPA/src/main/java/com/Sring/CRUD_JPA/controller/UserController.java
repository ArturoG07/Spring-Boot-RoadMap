package com.Sring.CRUD_JPA.controller;

import com.Sring.CRUD_JPA.model.User;
import com.Sring.CRUD_JPA.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for CRUD requests.
 */
@RestController
public class UserController {
    //Injecting the IUserService to handle user-related operations
    @Autowired
    private IUserService userService;


    //Create user endpoint
    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        String responseMessage;
        try {
            userService.createUser(user);
            responseMessage = "User created successfully";
        } catch (Exception e) {
            responseMessage = "Error creating user";
        }
        return responseMessage;
    }

    //Read user endpoint
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            throw new RuntimeException("User not found with id: " + id);
        }
        return user;
    }

    //Update user endpoint
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable Long id,
                             @RequestParam(required = false, name="name") String newName,
                             @RequestParam(required = false, name="email") String newEmail,
                             @RequestParam(required = false, name="age") Integer newAge) {

        String responseMessage;
        try {
            userService.updateUser(id,  newName, newEmail, newAge);
            responseMessage = "User updated successfully";
        } catch (Exception e) {
            responseMessage = "Error updating user";
        }
        return responseMessage;

    }

    //Delete user endpoint
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        String responseMessage;
        try {
            userService.deleteUser(id);
            responseMessage = "User deleted successfully";
        } catch (Exception e) {
            responseMessage = "Error deleting user";
        }
        return responseMessage;
    }




}
