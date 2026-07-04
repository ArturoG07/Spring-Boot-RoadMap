package com.Spring.hospital.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Patient object
 */
@Getter @Setter
public class Patient {
    private int id;
    private String name;
    private LocalDate birthdate;

    public Patient(int id, String name, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Patient() {
    }
}
