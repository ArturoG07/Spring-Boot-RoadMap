package com.Spring.JPA_Relations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Getter @Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    /**
     * ManyToMany owning side:
     * A department can have multiple users,
     * and a user can belong to multiple departments.
     * JoinTable defines the intermediate table
     * used to connect both entities.
     * joinColumns defines the foreign key referencing Department.
     * inverseJoinColumns defines the foreign key referencing User.
     */
    @ManyToMany
    @JoinTable(
            name = "user_department",
            joinColumns = @JoinColumn(name = "department_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> usersList;
}