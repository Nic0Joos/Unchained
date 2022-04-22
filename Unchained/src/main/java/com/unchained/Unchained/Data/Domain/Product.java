package com.unchained.Unchained.Data.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private Long maxAmount;
    private Long minPalletSpace;
    private Long price;

    //getter and setter
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getMaxAmount() {
        return maxAmount;
    }
    public void setMaxAmount(Long maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Long getMinPalletSpace() {
        return minPalletSpace;
    }
    public void setMinPalletSpace(Long minPalletSpace) {
        this.minPalletSpace = minPalletSpace;
    }

    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }
}
