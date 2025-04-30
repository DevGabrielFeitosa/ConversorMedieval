package com.conversor.conversor_medieval.productConversion;

import java.math.BigDecimal;

public record ProductConversionResponseDTO(
        BigDecimal originalValue,
        BigDecimal convertedValue,
        String message,
        String conversionDetails
) {}
