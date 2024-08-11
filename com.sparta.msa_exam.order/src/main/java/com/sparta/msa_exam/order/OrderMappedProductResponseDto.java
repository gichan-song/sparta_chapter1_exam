package com.sparta.msa_exam.order;

import java.util.ArrayList;
import java.util.List;

public class OrderMappedProductResponseDto {
    public List<Long> productList = new ArrayList<Long>();

    OrderMappedProductResponseDto(Order order) {
        for (OrderMappedProduct orderMappedProduct : order.getProduct_ids()) {
            this.productList.add(orderMappedProduct.getProduct_id());
        }
    }
}
