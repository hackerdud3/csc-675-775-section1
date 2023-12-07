package com.section1.spring.datajpa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @Column(name = "cid")
    private Integer cid;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "payment_info")
    private String paymentInfo;

    @Column(name = "address")
    private String address;

    public Customer() {

    }

    public Customer(Integer cid, String name, String paymentInfo, String address) {
        this.cid = cid;
        this.name = name;
        this.paymentInfo = paymentInfo;
        this.address = address;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(String paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", paymentInfo='" + paymentInfo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
