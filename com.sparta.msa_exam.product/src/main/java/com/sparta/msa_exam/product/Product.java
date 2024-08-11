package com.sparta.msa_exam.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column
    private String name;

    @Column
    private Integer supply_price;

    Product(ProductRequestDto requestDto) {
        this.name = requestDto.getName();
        this.supply_price = requestDto.getSupply_price();
    }
}
