package com.sparta.msa_exam.order;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/order")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto requestDto, HttpServletResponse response) {
        response.addHeader("Server-port", serverPort);
        return orderService.createOrder(requestDto);
    }

    @PutMapping("/order/{orderId}")
    public OrderMappedProductResponseDto addProduct(
            @PathVariable("orderId") Long orderId,
            @RequestBody OrderMappedProductRequestDto requestDto,
            HttpServletResponse response) {
        response.addHeader("Server-port", serverPort);
        return orderService.addProduct(orderId, requestDto);
    }
    @GetMapping("/order/{orderId}")
    public OrderResponseDto getOrder(@PathVariable("orderId") Long orderId, HttpServletResponse response) {
        response.addHeader("Server-port", serverPort);
        return orderService.getOrder(orderId);
    }
}
