package com.Spring.FinalProyect.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long customerCode) {
        super("Customer not found with code: " + customerCode);
    }
}
