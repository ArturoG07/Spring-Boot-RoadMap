package com.Spring.VetClinic.mapper;

import com.Spring.VetClinic.dto.OwnerRequestDTO;
import com.Spring.VetClinic.dto.OwnerResponseDTO;
import com.Spring.VetClinic.model.Owner;
import org.springframework.stereotype.Component;

@Component
public class OwnerMapper {

    public OwnerResponseDTO toDTO(Owner owner) {
        return new OwnerResponseDTO(
                owner.getId(),
                owner.getName(),
                owner.getEmail(),
                owner.getCellPhone()
        );

    }
    public Owner toEntity(OwnerRequestDTO dto) {
        Owner owner = new Owner();
        owner.setName(dto.getName());
        owner.setEmail(dto.getEmail());
        owner.setCellPhone(dto.getCellPhone());
        return owner;
    }
    public void updateEntity(Owner owner, OwnerRequestDTO dto) {
        owner.setName(dto.getName());
        owner.setEmail(dto.getEmail());
        owner.setCellPhone(dto.getCellPhone());
    }
}
