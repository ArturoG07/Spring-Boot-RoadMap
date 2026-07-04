package com.Spring.DTO_Pattern.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Guest {
    private int id;
    private String name;
    private int property_id;
    private String time_period;

    public Guest(int id, String name, String time_period, int property_id) {
        this.id = id;
        this.name = name;
        this.time_period = time_period;
        this.property_id = property_id;
    }

    public Guest() {
    }
}
