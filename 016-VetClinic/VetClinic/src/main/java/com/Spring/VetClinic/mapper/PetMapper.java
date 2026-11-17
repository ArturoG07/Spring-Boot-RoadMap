package com.Spring.VetClinic.mapper;

import com.Spring.VetClinic.dto.PetRequestDTO;
import com.Spring.VetClinic.dto.PetOwnerDTO;
import com.Spring.VetClinic.dto.PetResponseDTO;
import com.Spring.VetClinic.model.Owner;
import com.Spring.VetClinic.model.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {
    public PetResponseDTO toDTO(Pet pet) {
        return new PetResponseDTO(
                pet.getId(),
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getColor(),
                pet.getOwner().getId()
        );
    }
    public Pet toEntity(PetRequestDTO dto, Owner owner) {
        Pet pet = new Pet();
        pet.setName(dto.getName());
        pet.setSpecies(dto.getSpecies());
        pet.setBreed(dto.getBreed());
        pet.setColor(dto.getColor());
        pet.setOwner(owner);
        return pet;
    }

    public PetOwnerDTO toPetOwnerDTO(Pet pet) {
        return new PetOwnerDTO(
                pet.getName(),
                pet.getSpecies(),
                pet.getBreed(),
                pet.getOwner().getName()
        );
    }

    public void updateEntity(Pet pet, PetRequestDTO dto, Owner owner) {
        pet.setName(dto.getName());
        pet.setSpecies(dto.getSpecies());
        pet.setBreed(dto.getBreed());
        pet.setColor(dto.getColor());
        pet.setOwner(owner);
    }
}
