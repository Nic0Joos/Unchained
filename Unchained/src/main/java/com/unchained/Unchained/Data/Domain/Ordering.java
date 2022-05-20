package com.unchained.Unchained.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

//Author: Luca
@Entity
public class Ordering {

    @Id
    @GeneratedValue
    private Long orderId;
    private int amountA;
    private int amountB;
    private int amountC;
    private int amountD;
    private Long shippingCost;
    private Long orderPrice;
    /*@ManyToOne
    @JsonIgnore
    private User user;*/


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public int getAmountA() {
        return amountA;
    }

    public void setAmountA(int amountA) {
        this.amountA = amountA;
    }

    public int getAmountB() {
        return amountB;
    }

    public void setAmountB(int amountB) {
        this.amountB = amountB;
    }

    public int getAmountC() {
        return amountC;
    }

    public void setAmountC(int amountC) {
        this.amountC = amountC;
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
    /*
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
