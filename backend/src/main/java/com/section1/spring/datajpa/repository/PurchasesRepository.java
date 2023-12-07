package com.section1.spring.datajpa.repository;

import com.section1.spring.datajpa.model.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasesRepository extends JpaRepository<Purchases, Integer> {
    @Query(value = "SELECT P.name as productName, SUM(Pu.purchase_quantity) AS purchaseQuantity " +
            "FROM Products P " +
            "JOIN Purchases Pu ON P.pid = Pu.pid " +
            "GROUP BY P.pid, P.name " +
            "HAVING purchaseQuantity > :quantity", nativeQuery = true)
    List<PurchasesRepositoryStats> findProductNamesAndTotalQuantity(Integer quantity);
}
