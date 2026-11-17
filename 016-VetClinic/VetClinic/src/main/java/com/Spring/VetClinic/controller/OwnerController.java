package com.Spring.VetClinic.controller;

import com.Spring.VetClinic.dto.OwnerRequestDTO;
import com.Spring.VetClinic.dto.OwnerResponseDTO;
import com.Spring.VetClinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @GetMapping("/owners/{id}")
    public OwnerResponseDTO getOwner(@PathVariable Long id) {
        return ownerService.getOwnerById(id);
    }

    @PostMapping("/owners")
    public OwnerResponseDTO addOwner(@RequestBody OwnerRequestDTO ownerRequestDTO) {
        return ownerService.createOwner(ownerRequestDTO);
    }

    @PutMapping("/owners/{id}")
    public OwnerResponseDTO updateOwner(@PathVariable Long id,
            @RequestBody OwnerRequestDTO ownerRequestDTO) {
        return ownerService.updateOwner(id, ownerRequestDTO);
    }

    @DeleteMapping("/owners/{id}")
    public void deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
    }

    @GetMapping("/owners")
    public List<OwnerResponseDTO> getOwners() {
        return ownerService.getAllOwners();
    }
}
