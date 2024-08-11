package com.sparta.msa_exam.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMappedProductRepository orderMappedProductRepository;
    private final ProductClient productClient;

    public OrderResponseDto createOrder(OrderRequestDto requestDto) {
        Order order = new Order(requestDto);
        orderRepository.save(order);
        return new OrderResponseDto(order);
    }

    public OrderMappedProductResponseDto addProduct(
            Long orderId, OrderMappedProductRequestDto requestDto) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order == null) {
            return null;
        }
        if (!productClient.isProductExist(requestDto.getProduct_id())) {
            return null;
        }
        OrderMappedProduct orderMappedProduct = new OrderMappedProduct(requestDto);
        order.addProduct(orderMappedProduct);
        orderMappedProductRepository.save(orderMappedProduct);
        orderRepository.save(order);
        return new OrderMappedProductResponseDto(order);
    }

    public OrderResponseDto getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        List<OrderMappedProduct> productList = orderMappedProductRepository.findAllByOrder(order);
        List<Long> productIdList = new ArrayList<>();
        for (OrderMappedProduct product : productList) {
            productIdList.add(product.getProduct_id());
        }
        return new OrderResponseDto(orderId, productIdList);

    }
}
