package com.Spring.VetClinic.service;

import com.Spring.VetClinic.dto.OwnerResponseDTO;
import com.Spring.VetClinic.dto.PetOwnerDTO;
import com.Spring.VetClinic.dto.PetRequestDTO;
import com.Spring.VetClinic.dto.PetResponseDTO;
import com.Spring.VetClinic.exception.OwnerNotFoundException;
import com.Spring.VetClinic.exception.PetNotFoundException;
import com.Spring.VetClinic.mapper.PetMapper;
import com.Spring.VetClinic.model.Owner;
import com.Spring.VetClinic.model.Pet;
import com.Spring.VetClinic.repository.OwnerRepository;
import com.Spring.VetClinic.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService implements IPetService {
    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PetMapper petMapper;
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public PetResponseDTO createPet(PetRequestDTO petRequestDto) {
        Owner owner = ownerRepository.findById(petRequestDto.getOwnerId())
                .orElseThrow(() -> new OwnerNotFoundException(petRequestDto.getOwnerId()));
        Pet saved = petRepository.save(petMapper.toEntity(petRequestDto, owner));
        return petMapper.toDTO(saved);
    }

    @Override
    public PetResponseDTO getPetById(Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
        return petMapper.toDTO(pet);
    }

    @Override
    public PetResponseDTO updatePet(Long id, PetRequestDTO petRequestDto) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
        Owner owner = ownerRepository.findById(petRequestDto.getOwnerId())
                .orElseThrow(() -> new OwnerNotFoundException(petRequestDto.getOwnerId()));

        petMapper.updateEntity(pet, petRequestDto, owner);
        Pet saved = petRepository.save(pet);
        return petMapper.toDTO(saved);
    }

    @Override
    public void deletePet(Long id) {
        if (!petRepository.existsById(id)) {
            throw new PetNotFoundException(id);
        }
        petRepository.deleteById(id);
    }

    @Override
    public List<PetOwnerDTO> getCombinatedList() {
        List<Pet> pets = petRepository.findAll();
        List<PetOwnerDTO> list = new ArrayList<>();
        for (Pet pet : pets) {
            list.add(petMapper.toPetOwnerDTO(pet));
        }
        return list;
    }

    @Override
    public List<PetResponseDTO> getAllPets() {
        List<Pet> pets = petRepository.findAll();
        List<PetResponseDTO> list = new ArrayList<>();
        for (Pet pet : pets) {
            list.add(petMapper.toDTO(pet));
        }
        return list;
    }
}
