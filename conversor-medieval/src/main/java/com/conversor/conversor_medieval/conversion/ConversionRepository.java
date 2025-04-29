package com.conversor.conversor_medieval.conversion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversionRepository extends JpaRepository<ConversionModel, Long> {

    @Query("SELECT c FROM ConversionModel c WHERE c.lastUpdatedDate = (" +
            "SELECT MAX(c2.lastUpdatedDate) FROM ConversionModel c2 " +
            "WHERE c2.fromCoin = c.fromCoin AND c2.toCoin = c.toCoin)")
    List<ConversionModel> findLatestConversionsByCoinPair();

}
