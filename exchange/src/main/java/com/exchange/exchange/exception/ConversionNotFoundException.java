package com.exchange.exchange.exception;

public class ConversionNotFoundException extends RuntimeException {
    public ConversionNotFoundException(Long id) {
        super("Conversion history not found with id: " + id);
    }
}
