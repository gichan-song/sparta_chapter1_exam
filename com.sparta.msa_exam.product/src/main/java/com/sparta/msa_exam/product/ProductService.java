package com.sparta.msa_exam.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto addProduct(ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        productRepository.save(product);
        return new ProductResponseDto(product);
    }
}
