package com.Spring.VetClinic.service;

import com.Spring.VetClinic.dto.PetOwnerDTO;
import com.Spring.VetClinic.dto.PetRequestDTO;
import com.Spring.VetClinic.dto.PetResponseDTO;

import java.util.List;

public interface IPetService {
    public PetResponseDTO createPet(PetRequestDTO petRequestDto);
    public PetResponseDTO getPetById(Long id);
    public PetResponseDTO updatePet(Long id, PetRequestDTO petRequestDto);
    public void deletePet(Long id);
    public List<PetOwnerDTO> getCombinatedList();
    public List<PetResponseDTO> getAllPets();
}
