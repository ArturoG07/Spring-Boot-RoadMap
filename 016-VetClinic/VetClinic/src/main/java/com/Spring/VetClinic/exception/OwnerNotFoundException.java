package com.Spring.VetClinic.exception;

public class OwnerNotFoundException extends RuntimeException {
    public OwnerNotFoundException(Long id) {
        super("Owner not found with Id: " + id);
    }
}
