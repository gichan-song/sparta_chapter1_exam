package com.sparta.msa_exam.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderMappedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Column
    private Long product_id;

    OrderMappedProduct(OrderMappedProductRequestDto requestDto) {
        this.product_id = requestDto.getProduct_id();
    }
}
