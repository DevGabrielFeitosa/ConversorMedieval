package com.conversor.conversor_medieval.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/conversion")
public class ConversionController {

    @Autowired
    ConversionService conversionService;

    @PostMapping
    public ResponseEntity<ConversionResponseDTO> createConversion(@RequestBody @Valid ConversionRequestDTO request) {
        ConversionResponseDTO response = conversionService.createConversion(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<String>> getCurrentConversions() {
        return ResponseEntity.ok(conversionService.getLatestConversions());
    }

}
