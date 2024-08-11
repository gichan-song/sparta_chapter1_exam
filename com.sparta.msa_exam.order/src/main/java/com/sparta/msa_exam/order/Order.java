package com.sparta.msa_exam.order;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;

    @Column
    private String name;

    @OneToMany(mappedBy = "order")
    public List<OrderMappedProduct> product_ids = new ArrayList<>();

    Order(OrderRequestDto requestDto) {
        this.name = requestDto.getName();
    }

    public void addProduct(OrderMappedProduct product) {
        this.product_ids.add(product);
        product.setOrder(this);
    }
}
