package com.conversor.conversor_medieval.productConversion;

import com.conversor.conversor_medieval.exceptions.ConversionRateNotFoundException;
import com.conversor.conversor_medieval.exceptions.InvalidCurrencyOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProductConversionExceptionHandler {

    @ExceptionHandler(ConversionRateNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleConversionRateNotFound(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("code", "CONVERSION_RATE_NOT_FOUND");
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InvalidCurrencyOperationException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCurrencyOperation(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("code", "INVALID_CURRENCY_OPERATION");
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}