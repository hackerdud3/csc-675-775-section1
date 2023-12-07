package com.section1.spring.datajpa.repository;

import java.math.BigDecimal;
import java.util.List;

import com.section1.spring.datajpa.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findCompaniesByOperationalCostGreaterThan(BigDecimal cost);
}
