package com.sparta.msa_exam.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/products")
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto requestDto) {
        return productService.addProduct(requestDto);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
