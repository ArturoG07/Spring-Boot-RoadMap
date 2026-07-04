package com.Spring.DTO_Pattern.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PropertyDTO {
    private int property_id;
    private int guest_id;
    private String guest_name;
    private String address;

    public PropertyDTO(int property_id, int guest_id, String guest_name, String address) {
        this.property_id = property_id;
        this.guest_id = guest_id;
        this.guest_name = guest_name;
        this.address = address;
    }

    public PropertyDTO() {
    }
}
