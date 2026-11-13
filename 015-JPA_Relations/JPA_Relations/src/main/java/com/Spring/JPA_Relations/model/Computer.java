package com.Spring.JPA_Relations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter @Setter
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String brand;

    private String model;

    /**
     * OneToOne inverse side:
     * mappedBy indicates that the relationship is managed
     * by the "computer" field in the User entity.
     * This side does not create an additional foreign key.
     */
    @OneToOne(mappedBy = "computer")
    private User user;
}
