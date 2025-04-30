package com.conversor.conversor_medieval.conversion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ConversionService {

    @Autowired
    private ConversionRepository conversionRepository;

    @Transactional
    public ConversionResponseDTO createConversion(ConversionRequestDTO request) {

        ConversionModel conversion = new ConversionModel();
        conversion.setFromCoin(request.fromCoin());
        conversion.setToCoin(request.toCoin());
        conversion.setCurrencyValue(request.value());

        ConversionModel savedConversion = conversionRepository.save(conversion);

        return new ConversionResponseDTO(
                savedConversion.getId(),
                savedConversion.getFromCoin(),
                savedConversion.getToCoin(),
                savedConversion.getCurrencyValue(),
                savedConversion.getLastUpdatedDate()
        );
    }

    public List<String> getLatestConversions() {
        List<ConversionModel> conversions = conversionRepository.findLatestConversionsByCoinPair();

        return conversions.stream()
                .map(this::formatConversionMessage)
                .collect(Collectors.toList());
    }

    private String formatConversionMessage(ConversionModel conversion) {
        BigDecimal directRate = conversion.getCurrencyValue();
        BigDecimal inverseRate = BigDecimal.ONE.divide(directRate, 4, RoundingMode.HALF_UP);

        NumberFormat rateFormat = NumberFormat.getInstance(new Locale("pt", "BR"));
        rateFormat.setMaximumFractionDigits(4);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM HH:mm");

        return String.format(
                "💎 1 %s = %s %s (📅 %s)",
                conversion.getFromCoin(),
                rateFormat.format(directRate),
                conversion.getToCoin(),
                dateFormat.format(conversion.getLastUpdatedDate())
        );
    }
}
