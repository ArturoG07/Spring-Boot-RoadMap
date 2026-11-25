package com.Spring.FinalProyect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class SaleRequestDTO {
    private LocalDate saleDate;
    private List<Long> productCodes;
    private Long customerCode;
}
