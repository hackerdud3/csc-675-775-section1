package com.section1.spring.datajpa.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface PurchasesRepositoryStats {
    String getProductName();
    Integer getPurchaseQuantity();
}
