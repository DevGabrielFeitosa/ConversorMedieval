package com.conversor.conversor_medieval.productConversion;

import com.conversor.conversor_medieval.coin.Coin;
import com.conversor.conversor_medieval.conversion.ConversionModel;
import com.conversor.conversor_medieval.exceptions.ConversionRateNotFoundException;
import com.conversor.conversor_medieval.products.ProductModel;
import com.conversor.conversor_medieval.products.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

@Service
public class ProductConversionService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductConversionRepository productConversionRepository;


    public ProductConversionResponseDTO convertProduct(ProductConversionRequestDTO request) {
        ProductModel product = getProductOrThrow(request.productId());
        Coin fromCoin = product.getOriginCoin();
        Coin toCoin = request.targetCoin();

        BigDecimal totalOriginal = calculateTotalValue(product, request.quantity());
        BigDecimal conversionRate = determineConversionRate(product, fromCoin, toCoin);
        BigDecimal convertedValue = totalOriginal.multiply(conversionRate);

        return buildResponse(product, totalOriginal, convertedValue, fromCoin, toCoin, conversionRate);
    }

    private ProductModel getProductOrThrow(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    private BigDecimal calculateTotalValue(ProductModel product, BigDecimal quantity) {
        return product.getUnitaryValue().multiply(quantity);
    }

    private BigDecimal determineConversionRate(ProductModel product, Coin fromCoin, Coin toCoin) {
        if (product.getSpecificConversion() != null) {
            return product.getSpecificConversion();
        }

        return productConversionRepository.findLatestByFromCoinAndToCoin(fromCoin, toCoin)
                .map(ConversionModel::getCurrencyValue)
                .orElseThrow(() -> new ConversionRateNotFoundException("Taxa de conversão não encontrada"));
    }

    private ProductConversionResponseDTO buildResponse(ProductModel product,
                                                    BigDecimal totalOriginal,
                                                    BigDecimal convertedValue,
                                                    Coin fromCoin,
                                                    Coin toCoin,
                                                    BigDecimal rate) {

        return new ProductConversionResponseDTO(
                totalOriginal,
                convertedValue,
                String.format("Conversão do produto '%s' concluída", product.getProductName()),
                String.format("%s %s ➔ %s %s (Taxa: %s)",
                        formatCurrency(totalOriginal, fromCoin),
                        fromCoin,
                        formatCurrency(convertedValue, toCoin),
                        toCoin,
                        rate.setScale(4, RoundingMode.HALF_UP))
        );
    }

    private String formatCurrency(BigDecimal value, Coin coin) {
        return String.format(Locale.forLanguageTag("pt-BR"),
                "%.2f %s",
                value,
                coin.name()
        );
    }
}
