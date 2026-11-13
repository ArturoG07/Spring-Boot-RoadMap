package com.Spring.JPA_Relations.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /**
     * OneToOne relation:
     * A user has only one computer, and a computer
     * belongs to only one user.
     * JoinColumn defines the foreign key column in the User table.
     * The name attribute specifies the foreign key column name.
     * The referencedColumnName specifies the column in the Computer
     * table that the foreign key references.
     * If referencedColumnName is omitted, JPA uses the primary key
     * of the referenced entity by default.
     */
    @OneToOne
    @JoinColumn(name = "computer_id")
    private Computer computer;

    /**
     * OneToMany relation:
     * A user can have multiple accounts, but each account
     * belongs to only one user.
     * mappedBy indicates the field in the Account entity
     * that owns and manages this relationship.
     * The foreign key is stored in the Account table,
     * not in the User table.
     */
    @OneToMany(mappedBy = "user")
    private List<Account> accountsList;

    /**
     * ManyToMany relation:
     * A user can belong to multiple departments,
     * and a department can have multiple users.
     * mappedBy indicates that the relationship is managed
     * by the "usersList" field in the Department entity.
     * This is the inverse side of the relationship.
     * The join table is defined in the Department entity.
     */
    @ManyToMany(mappedBy = "usersList")
    private List<Department> departmentsList;
}