package com.sparta.msa_exam.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Order order = new Order(requestDto);
        orderRepository.save(order);
        return new OrderResponseDto(order);
    }
}
