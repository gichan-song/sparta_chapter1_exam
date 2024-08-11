package com.sparta.msa_exam.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderMappedProductRepository extends JpaRepository<OrderMappedProduct, Long> {
    List<OrderMappedProduct> findAllByOrder(Order order);
}
