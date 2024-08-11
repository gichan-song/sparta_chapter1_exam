package com.sparta.msa_exam.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto requestDto) {
        return productService.addProduct(requestDto);
    }
}
