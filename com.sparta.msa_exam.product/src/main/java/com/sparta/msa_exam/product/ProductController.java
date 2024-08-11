package com.sparta.msa_exam.product;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/products")
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto requestDto, HttpServletResponse response) {
        response.addHeader("Server-Port", serverPort);
        return productService.addProduct(requestDto);
    }

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts(HttpServletResponse response) {
        response.addHeader("Server-Port", serverPort);
        return productService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public Boolean isProductExist(@PathVariable Long productId, HttpServletResponse response) {
        response.addHeader("Server-Port", serverPort);
        return productService.isProductExist(productId);
    }
}
