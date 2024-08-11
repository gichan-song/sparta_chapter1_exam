package com.sparta.msa_exam.product;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class ProductRequestDto {
    private String name;
    private Integer supply_price;
}
