package com.sparta.msa_exam.order;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderResponseDto implements Serializable {
    public Long order_id;
    public List<Long>  product_ids = new ArrayList<>();

    OrderResponseDto(Order order) {
        this.order_id = order.getOrder_id();
    }
    OrderResponseDto(Long orderId, List<Long> productIds) {
        this.order_id = orderId;
        this.product_ids = productIds;
    }
}
