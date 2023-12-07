package com.section1.spring.datajpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column(name = "name")
    @NotNull
    private String productName;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    public Products() {

    }

    public Products(Integer pid, String productName, Integer quantity, BigDecimal price) {
        this.pid = pid;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", name='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
