package com.conversor.conversor_medieval.products;

import com.conversor.conversor_medieval.coin.Coin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank(message = "O nome do produto é obrigatório")
        String productName,

        @NotBlank(message = "A natureza do produto é obrigatória")
        String nature,

        @NotBlank(message = "O Reino de origem do produto é obrigatório")
        String originKingdom,

        @NotNull(message = "A moeda de origem é obrigatória")
        Coin originCoin,

        @Positive(message = "A conversão específica deve ser positiva")
        BigDecimal specificConversion,

        @Positive(message = "O valor do produto deve ser positivo")
        @NotNull(message = "O valor do produto é obrigatório")
        BigDecimal unitaryValue
) {}
