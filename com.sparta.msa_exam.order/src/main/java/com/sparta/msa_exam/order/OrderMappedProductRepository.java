package com.sparta.msa_exam.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMappedProductRepository extends JpaRepository<OrderMappedProduct, Long> {
}
