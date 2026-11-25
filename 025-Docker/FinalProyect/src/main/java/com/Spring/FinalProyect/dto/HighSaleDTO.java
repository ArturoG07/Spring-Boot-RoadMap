package com.Spring.FinalProyect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class HighSaleDTO {
    private Long saleCode;
    private Double total;
    private Integer productsNumber;
    private String customerFirstName;
    private String customerLastName;
}
