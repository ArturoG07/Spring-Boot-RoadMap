package com.Spring.DTO_Pattern.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Property {
    private int id;
    private String address;
    private double m2;
    private double price;

    public Property(int id, String address, double m2, double price) {
        this.id = id;
        this.address = address;
        this.m2 = m2;
        this.price = price;
    }

    public Property() {
    }
}
