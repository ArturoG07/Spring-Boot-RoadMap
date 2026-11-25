package com.Spring.FinalProyect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SaleResponseDTO {
    private Long saleCode;
    private LocalDate saleDate;
    private Double total;
    private List<ProductResponseDTO> productList;
    private CustomerResponseDTO customer;
}
