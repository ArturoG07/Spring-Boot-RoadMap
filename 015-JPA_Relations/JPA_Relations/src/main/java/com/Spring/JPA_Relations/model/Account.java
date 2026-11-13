package com.Spring.JPA_Relations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter @Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    /**
     * ManyToOne relation:
     * Multiple accounts can belong to the same user,
     * but each account belongs to only one user.
     * JoinColumn defines the foreign key column
     * in the Account table.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}