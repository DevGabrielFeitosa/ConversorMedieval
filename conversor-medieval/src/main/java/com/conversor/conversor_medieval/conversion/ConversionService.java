package com.conversor.conversor_medieval.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConversionService {

    @Autowired
    private ConversionRepository conversionRepository;

    public ConversionResponseDTO createConversion(@RequestBody @Valid ConversionRequestDTO request) {

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

    public List<ConversionResponseDTO> getLatestConversions(){

        List<ConversionModel> conversionModels = conversionRepository.findLatestConversionsByCoinPair();


        return conversionModels.stream()
                .map(c -> new ConversionResponseDTO(
                        c.getId(),
                        c.getFromCoin(),
                        c.getToCoin(),
                        c.getCurrencyValue(),
                        c.getLastUpdatedDate()
                ))
                .collect(Collectors.toList());
    }
}
