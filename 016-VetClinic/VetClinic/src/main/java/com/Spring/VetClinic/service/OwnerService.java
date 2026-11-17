package com.Spring.VetClinic.service;

import com.Spring.VetClinic.dto.OwnerRequestDTO;
import com.Spring.VetClinic.dto.OwnerResponseDTO;
import com.Spring.VetClinic.exception.OwnerNotFoundException;
import com.Spring.VetClinic.mapper.OwnerMapper;
import com.Spring.VetClinic.model.Owner;
import com.Spring.VetClinic.model.Pet;
import com.Spring.VetClinic.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService implements IOwnerService {
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private OwnerMapper ownerMapper;

    @Override
    public OwnerResponseDTO createOwner(OwnerRequestDTO ownerRequestDto) {
        Owner saved = ownerRepository.save(ownerMapper.toEntity(ownerRequestDto));
        return ownerMapper.toDTO(saved);
    }

    @Override
    public OwnerResponseDTO getOwnerById(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException(id));
        return ownerMapper.toDTO(owner);
    }

    @Override
    public OwnerResponseDTO updateOwner(Long id, OwnerRequestDTO ownerRequestDto) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new OwnerNotFoundException(id));
        ownerMapper.updateEntity(owner, ownerRequestDto);
        Owner saved = ownerRepository.save(owner);
        return ownerMapper.toDTO(saved);
    }

    @Override
    public void deleteOwner(Long id) {
        if (!ownerRepository.existsById(id)) {
            throw new OwnerNotFoundException(id);
        }
        ownerRepository.deleteById(id);
    }

    @Override
    public List<OwnerResponseDTO> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        List<OwnerResponseDTO> list = new ArrayList<>();
        for (Owner owner : owners) {
            list.add(ownerMapper.toDTO(owner));
        }
        return list;
    }
}
