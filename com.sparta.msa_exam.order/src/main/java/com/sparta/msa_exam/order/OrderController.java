package com.sparta.msa_exam.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(requestDto);
    }

    @PutMapping("/order/{orderId}")
    public OrderMappedProductResponseDto addProduct(
            @PathVariable("orderId") Long orderId,
            @RequestBody OrderMappedProductRequestDto requestDto) {
        return orderService.addProduct(orderId, requestDto);
    }
    @GetMapping("/order/{orderId}")
    public OrderResponseDto getOrder(@PathVariable("orderId") Long orderId) {
        return orderService.getOrder(orderId);
    }
}
