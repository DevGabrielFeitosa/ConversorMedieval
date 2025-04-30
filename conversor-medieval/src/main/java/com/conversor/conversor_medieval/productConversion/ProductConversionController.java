package com.conversor.conversor_medieval.productConversion;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
@RequiredArgsConstructor
public class ProductConversionController {

    @Autowired
    private ProductConversionService conversionService;

    @PostMapping()
    public ResponseEntity<ProductConversionResponseDTO> convertProduct(
            @Valid @RequestBody ProductConversionRequestDTO request) {

        return ResponseEntity.ok(conversionService.convertProduct(request));
    }
}
