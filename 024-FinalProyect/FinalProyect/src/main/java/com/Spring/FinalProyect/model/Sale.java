package com.Spring.FinalProyect.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long saleCode;
    private LocalDate saleDate;
    private Double total;
    @ManyToMany
    private List<Product> productList;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
