package com.conversor.conversor_medieval.productConversion;

import com.conversor.conversor_medieval.coin.Coin;
import com.conversor.conversor_medieval.conversion.ConversionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductConversionRepository extends JpaRepository<ConversionModel, Long> {

    @Query("SELECT c FROM ConversionModel c " +
            "WHERE c.fromCoin = :fromCoin AND c.toCoin = :toCoin " +
            "ORDER BY c.lastUpdatedDate DESC LIMIT 1")
    Optional<ConversionModel> findLatestByFromCoinAndToCoin(
            @Param("fromCoin") Coin fromCoin,
            @Param("toCoin") Coin toCoin);

}
