package com.conversor.conversor_medieval.products;

import com.conversor.conversor_medieval.coin.Coin;

import java.math.BigDecimal;

public record ProductResponseDTO(Long id,
                                 String productName,
                                 String nature,
                                 String originKingdom,
                                 Coin originCoin,
                                 BigDecimal specificConversion,
                                 BigDecimal unitaryValue
) {}
