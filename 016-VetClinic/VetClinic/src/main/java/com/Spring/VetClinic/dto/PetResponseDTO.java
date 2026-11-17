package com.Spring.VetClinic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class PetResponseDTO {
    private Long id;
    private String name;
    private String species;
    private String breed;
    private String color;
    private Long ownerId;
}
