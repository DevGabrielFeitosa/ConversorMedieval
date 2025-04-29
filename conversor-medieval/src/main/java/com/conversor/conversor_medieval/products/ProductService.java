package com.conversor.conversor_medieval.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductResponseDTO createProduct(@RequestBody @Valid ProductRequestDTO request) {
        ProductModel product = new ProductModel();
        product.setProductName(request.productName());
        product.setNature(request.nature());
        product.setOriginKingdom(request.originKingdom());
        product.setOriginCoin(request.originCoin());
        product.setSpecificConversion(request.specificConversion());
        product.setUnitaryValue(request.value());

        ProductModel savedProduct = productRepository.save(product);

        return new ProductResponseDTO(
                savedProduct.getId(),
                savedProduct.getProductName(),
                savedProduct.getNature(),
                savedProduct.getOriginKingdom(),
                savedProduct.getOriginCoin(),
                savedProduct.getSpecificConversion(),
                savedProduct.getUnitaryValue()
        );
    }

}
