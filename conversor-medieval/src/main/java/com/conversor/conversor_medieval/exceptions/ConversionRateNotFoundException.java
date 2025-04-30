package com.conversor.conversor_medieval.exceptions;

public class ConversionRateNotFoundException extends RuntimeException {
    public ConversionRateNotFoundException(String message) {
        super(message);
    }
}