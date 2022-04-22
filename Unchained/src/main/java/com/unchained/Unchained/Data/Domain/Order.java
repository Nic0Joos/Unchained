package com.unchained.Unchained.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long orderId;
    @OneToMany(mappedBy = "Order")
    private Set<Product> products;
    private Long shippingCost;
    private Long orderPrice;
    @ManyToOne
    @JsonIgnore
    private User user;

    //getter and setter
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Set<Product> getProducts() {
        return products;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
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
