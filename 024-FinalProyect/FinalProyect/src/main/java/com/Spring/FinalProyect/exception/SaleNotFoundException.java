package com.Spring.FinalProyect.exception;

public class SaleNotFoundException extends RuntimeException {
    public SaleNotFoundException(Long saleCode) {
        super("Sale not found with code: " + saleCode);
    }
}
