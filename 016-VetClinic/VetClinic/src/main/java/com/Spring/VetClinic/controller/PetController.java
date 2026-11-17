package com.Spring.VetClinic.controller;

import com.Spring.VetClinic.dto.PetOwnerDTO;
import com.Spring.VetClinic.dto.PetRequestDTO;
import com.Spring.VetClinic.dto.PetResponseDTO;
import com.Spring.VetClinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("/pets/{id}")
    public PetResponseDTO getPet(@PathVariable Long id) {
        return petService.getPetById(id);
    }

    @PostMapping("/pets")
    public PetResponseDTO addPet(@RequestBody PetRequestDTO petRequestDTO) {
        return petService.createPet(petRequestDTO);
    }

    @PutMapping("/pets/{id}")
    public PetResponseDTO updatePet(@PathVariable Long id,
                            @RequestBody PetRequestDTO petRequestDTO) {
        return petService.updatePet(id, petRequestDTO);
    }
    @DeleteMapping("/pets/{id}")
    public void deletePet(@PathVariable Long id) {
        petService.deletePet(id);
    }

    @GetMapping("/pets/with-owners")
    public List<PetOwnerDTO> getPets() {
        return petService.getCombinatedList();
    }

    @GetMapping("/pets")
    public List<PetResponseDTO> getAllPets() {
        return petService.getAllPets();
    }
}
