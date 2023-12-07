package com.section1.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Purchases")
@IdClass(PurchasesPK.class)
public class Purchases {

    @Id
    @Column(name = "cid")
    private Integer cid;

    @Id
    @Column(name = "pid")
    private Integer pid;

    @Column(name = "purchase_quantity")
    private Integer purchaseQuantity;

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "pid", referencedColumnName = "pid", insertable = false, updatable = false)
    private Products product;

    public Purchases() {

    }

    public Purchases(Integer cid, Integer pid, Integer purchaseQuantity) {
        this.cid = cid;
        this.pid = pid;
        this.purchaseQuantity = purchaseQuantity;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
