package com.conversor.conversor_medieval.conversion;

import com.conversor.conversor_medieval.coin.Coin;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "conversion")
@AllArgsConstructor
@NoArgsConstructor
public class ConversionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Necessário informar a moeda raiz.")
    @Enumerated(EnumType.STRING)
    private Coin fromCoin;

    @NotNull(message = "Necessário informar a moeda destino.")
    @Enumerated(EnumType.STRING)
    private Coin toCoin;

    @NotNull(message = "Necessário informar o valor da nova cotação.")
    @Positive(message = "Valor não pode ser negativo")
    private BigDecimal currencyValue;

    private Date lastUpdatedDate = new Date();

    public Long getId() {
        return id;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public Coin getFromCoin() {
        return fromCoin;
    }

    public void setFromCoin(Coin fromCoin) {
        this.fromCoin = fromCoin;
    }

    public Coin getToCoin() {
        return toCoin;
    }

    public void setToCoin(Coin toCoin) {
        this.toCoin = toCoin;
    }

    public BigDecimal getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(BigDecimal convertedValue) {
        this.currencyValue = convertedValue;
    }

    @AssertTrue(message = "Moedas de origem e destino não podem ser iguais")
    public boolean isDifferentCoins() {
        return !fromCoin.equals(toCoin);
    }
}
