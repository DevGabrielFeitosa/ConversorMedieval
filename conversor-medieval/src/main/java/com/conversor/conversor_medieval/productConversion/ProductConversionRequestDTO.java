package com.conversor.conversor_medieval.productConversion;

import com.conversor.conversor_medieval.coin.Coin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductConversionRequestDTO(@NotNull(message = "Necessário informar o ID do produto.")
                                          Long productId,
                                          @Positive(message = "Valor não pode ser negativo")
                                          BigDecimal quantity,
                                          @NotNull(message = "Necessário informar a moeda da compra.")
                                          Coin targetCoin) {
}
