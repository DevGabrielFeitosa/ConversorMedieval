package com.conversor.conversor_medieval.products;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductResponseDTO createProduct(ProductRequestDTO request) {
        ProductModel product = new ProductModel();
        product.setProductName(request.productName());
        product.setNature(request.nature());
        product.setOriginKingdom(request.originKingdom());
        product.setOriginCoin(request.originCoin());
        product.setSpecificConversion(request.specificConversion());
        product.setUnitaryValue(request.unitaryValue());

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
