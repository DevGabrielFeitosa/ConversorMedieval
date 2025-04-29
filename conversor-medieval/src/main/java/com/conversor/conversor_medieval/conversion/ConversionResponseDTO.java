package com.conversor.conversor_medieval.conversion;

import com.conversor.conversor_medieval.coin.Coin;

import java.math.BigDecimal;
import java.util.Date;

public record ConversionResponseDTO(Long id,
                                    Coin fromCoin,
                                    Coin toCoin,
                                    BigDecimal convertedValue,
                                    Date lastUpdatedDate) {}
