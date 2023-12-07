package com.section1.spring.datajpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "Employees", indexes = @Index(name = "idx_employees_ssn", columnList = "ssn"))
public class Employees {

    @Id
    @Column(name = "ssn", nullable = false)
    private Integer ssn;

    @Column(name = "role")
    private String role;

    @Column(name = "salary")
    private BigDecimal salary;

    public Employees() {

    }

    public Employees(Integer ssn, String role, BigDecimal salary) {
        this.ssn = ssn;
        this.role = role;
        this.salary = salary;
    }

    public Integer getSsn() {
        return ssn;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ssn=" + ssn +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                '}';
    }
}
