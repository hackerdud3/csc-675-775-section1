package com.section1.spring.datajpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "Company", indexes = @Index(name = "idx_company_name", columnList = "name"))
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "revenue")
	private BigDecimal revenue;

	@Column(name = "operational_cost")
	private BigDecimal operationalCost;

	public Company() {

	}

	public Long getId() {
		return id;
	}

	public Company(Long id, String name, BigDecimal revenue, BigDecimal operationalCost) {
		this.id = id;
		this.name = name;
		this.revenue = revenue;
		this.operationalCost = operationalCost;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getRevenue() {
		return revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public BigDecimal getOperationalCost() {
		return operationalCost;
	}

	public void setOperationalCost(BigDecimal operationalCost) {
		this.operationalCost = operationalCost;
	}

	@Override
	public String toString() {
		return "Company{" +
				"id=" + id +
				", name='" + name + '\'' +
				", revenue=" + revenue +
				", operationalCost=" + operationalCost +
				'}';
	}
}
