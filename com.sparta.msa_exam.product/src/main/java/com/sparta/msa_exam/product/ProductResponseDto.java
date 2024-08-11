package com.sparta.msa_exam.product;

import java.io.Serializable;

public class ProductResponseDto implements Serializable {
    public Long product_id;

    public String name;

    public Integer supply_price;

    ProductResponseDto(Product product) {
        this.product_id = product.getProduct_id();
        this.name = product.getName();
        this.supply_price = product.getSupply_price();
    }
}
