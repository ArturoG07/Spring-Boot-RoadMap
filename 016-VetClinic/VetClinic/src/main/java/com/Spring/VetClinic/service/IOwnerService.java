package com.Spring.VetClinic.service;

import com.Spring.VetClinic.dto.OwnerRequestDTO;
import com.Spring.VetClinic.dto.OwnerResponseDTO;

import java.util.List;

public interface IOwnerService {
    public OwnerResponseDTO createOwner(OwnerRequestDTO owner);
    public OwnerResponseDTO getOwnerById(Long id);
    public OwnerResponseDTO updateOwner(Long id, OwnerRequestDTO newOwner);
    public void deleteOwner(Long id);
    public List<OwnerResponseDTO> getAllOwners();
}
