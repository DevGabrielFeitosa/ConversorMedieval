package com.conversor.conversor_medieval.conversion;

import com.conversor.conversor_medieval.coin.Coin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


import java.math.BigDecimal;

public record ConversionRequestDTO(@NotNull(message = "Moeda de origem é obrigatória")
                                    Coin fromCoin,

                                   @NotNull(message = "Moeda de destino é obrigatória")
                                    Coin toCoin,

                                   @Positive(message = "O valor deve ser positivo")
                                   @NotNull(message = "Valor é obrigatório")
                                   BigDecimal value) {}
