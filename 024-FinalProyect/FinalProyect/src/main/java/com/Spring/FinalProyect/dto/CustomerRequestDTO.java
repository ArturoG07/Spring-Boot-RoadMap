package com.Spring.FinalProyect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CustomerRequestDTO {
    private String firstName;
    private String lastName;
    private String nationalId;
}
