package com.unchained.Unchained.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

//Author: Luca
@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    private String productA;
    private int amountA;
    private String productB;
    private int amountB;
    private String productC;
    private int amountC;
    private String productD;
    private int amountD;
    private Long shippingCost;
    private Long orderPrice;
    @OneToOne
    @JsonIgnore
    private User user;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getProductA() {
        return productA;
    }

    public void setProductA(String productA) {
        this.productA = productA;
    }

    public int getAmountA() {
        return amountA;
    }

    public void setAmountA(int amountA) {
        this.amountA = amountA;
    }

    public String getProductB() {
        return productB;
    }

    public void setProductB(String productB) {
        this.productB = productB;
    }

    public int getAmountB() {
        return amountB;
    }

    public void setAmountB(int amountB) {
        this.amountB = amountB;
    }

    public String getProductC() {
        return productC;
    }

    public void setProductC(String productC) {
        this.productC = productC;
    }

    public int getAmountC() {
        return amountC;
    }

    public void setAmountC(int amountC) {
        this.amountC = amountC;
    }

    public String getProductD() {
        return productD;
    }

    public void setProductD(String productD) {
        this.productD = productD;
    }

    public int getAmountD() {
        return amountD;
    }

    public void setAmountD(int amountD) {
        this.amountD = amountD;
    }

    public Long getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Long shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
