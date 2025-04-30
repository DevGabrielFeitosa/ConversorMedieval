package com.conversor.conversor_medieval.products;

import com.conversor.conversor_medieval.coin.Coin;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private String nature;

    private String originKingdom;

    @Enumerated(EnumType.STRING)
    private Coin originCoin;

    private BigDecimal specificConversion;

    private BigDecimal unitaryValue;

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getOriginKingdom() {
        return originKingdom;
    }

    public void setOriginKingdom(String originKingdom) {
        this.originKingdom = originKingdom;
    }

    public BigDecimal getSpecificConversion() {
        return specificConversion;
    }

    public void setSpecificConversion(BigDecimal specificConversion) {
        this.specificConversion = specificConversion;
    }

    public BigDecimal getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(BigDecimal value) {
        this.unitaryValue = value;
    }

    public Coin getOriginCoin() {
        return originCoin;
    }

    public void setOriginCoin(Coin originCoin) {
        this.originCoin = originCoin;
    }
}
