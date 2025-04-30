package com.conversor.conversor_medieval.exceptions;

public class InvalidCurrencyOperationException extends RuntimeException {
    public InvalidCurrencyOperationException(String message) {
        super(message);
    }
}