package com.sparta.msa_exam.order;

public class OrderResponseDto {
    public Long order_id;
    public String name;

    OrderResponseDto(Order order) {
        this.order_id = order.getOrder_id();
        this.name = order.getName();
    }
}
