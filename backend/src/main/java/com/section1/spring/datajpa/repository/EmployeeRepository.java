package com.section1.spring.datajpa.repository;

import com.section1.spring.datajpa.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

    @Query(value = "SELECT e.role AS role, MAX(e.salary) AS MaxSalary, AVG(e.salary) AS AvgSalary " +
            "FROM Employees e " +
            "GROUP BY e.role " +
            "HAVING AVG(e.salary) >= :minAvgSalary", nativeQuery = true)
    List<EmployeeSalaryStats> findRoleMaxSalaryAvgSalary(double minAvgSalary);
}
