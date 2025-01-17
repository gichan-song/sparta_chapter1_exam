package com.sparta.msa_exam.product;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @CacheEvict(cacheNames = "products", allEntries = true)
    public ProductResponseDto addProduct(ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        productRepository.save(product);
        return new ProductResponseDto(product);
    }

    @Cacheable(cacheNames = "products")
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> response = new ArrayList<>();
        for (Product product : products) {
            response.add(new ProductResponseDto(product));
        }
        return response;
    }

    public Boolean isProductExist(Long productId) {
        return productRepository.existsById(productId);
    }
}
