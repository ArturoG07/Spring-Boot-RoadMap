package com.Spring.JPA_Hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity // JPA: marks this class as a database table (table "person")
public class User {

    @Id // JPA: marks this field as the primary key of the table
    // JPA: the id is generated automatically, so we don't set it by hand, uses a sequence to get the next value (MySQL emulates it with a table)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    private int age;
}
