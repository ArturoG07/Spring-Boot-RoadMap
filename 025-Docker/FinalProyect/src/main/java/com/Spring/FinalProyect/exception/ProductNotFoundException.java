package com.Spring.FinalProyect.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long productCode) {
        super("Product not found with code: " + productCode);
    }
}
