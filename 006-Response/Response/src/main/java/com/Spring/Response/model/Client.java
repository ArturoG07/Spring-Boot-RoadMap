package com.Spring.Response.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Client {
    private int id;
    private String name;
    private String surname;

    public Client(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Client() {
    }
}
