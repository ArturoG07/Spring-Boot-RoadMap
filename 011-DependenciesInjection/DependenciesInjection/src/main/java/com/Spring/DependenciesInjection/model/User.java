package com.Spring.DependenciesInjection.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    String name;
    int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

}
