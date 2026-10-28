package com.Spring.DependenciesInjection.controller;

import com.Spring.DependenciesInjection.model.User;
import com.Spring.DependenciesInjection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Uses 3 different dependencies injection methods
 */
@RestController
public class DependenciesInjectionController {


    // Injection via AutoWired
    @Autowired
    private UserRepository repositoryByAnnotation;

    //Injection via constructor
    private final UserRepository repositoryByConstructor;
    public DependenciesInjectionController(UserRepository repositoryByConstructor) {
        this.repositoryByConstructor = repositoryByConstructor;
    }


    //Injection via setter
    private UserRepository repositoryBySetter;
    @Autowired
    public void setRepositoryBySetter(UserRepository repositoryBySetter) {
        this.repositoryBySetter = repositoryBySetter;
    }


    @GetMapping("/users/annotation")
    public List<User> getUsersByAnnotation() {
        return repositoryByAnnotation.getAll();
    }

    @GetMapping("/users/constructor")
    public List<User> getUsersByConstructor() {
        return repositoryByConstructor.getAll();
    }

    @GetMapping("/users/setter")
    public List<User> getUsersBySetter() {
        return repositoryBySetter.getAll();
    }
}