package com.sparta.msa_exam.order;

import jakarta.persistence.*;

@Entity
public class OrderMappedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Column
    private Long product_id;
}
