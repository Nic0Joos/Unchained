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
    private Double minPalletSpace;
    private Double price;

    public Product(String productName, Long maxAmount, Double minPalletSpace, Double price) {
        this.productName = productName;
        this.maxAmount = maxAmount;
        this.minPalletSpace = minPalletSpace;
        this.price = price;
    }

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

    public Double getMinPalletSpace() {
        return minPalletSpace;
    }

    public void setMinPalletSpace(Double minPalletSpace) {
        this.minPalletSpace = minPalletSpace;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
