package com.Spring.RepositoryService.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Person {
    private Long id;
    private String name;
    private String surname;

    public Person(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Person() {
    }
}
