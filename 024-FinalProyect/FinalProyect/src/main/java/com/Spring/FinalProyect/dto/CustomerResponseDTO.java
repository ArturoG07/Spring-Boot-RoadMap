package com.Spring.FinalProyect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CustomerResponseDTO {
    private Long customerCode;
    private String firstName;
    private String lastName;
    private String nationalId;
}
