package com.section1.spring.datajpa.repository;

import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeSalaryStats {
    String getRole();
    Double getMaxSalary();
    Double getAvgSalary();
}
