package com.unchained.Unchained.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;


//Author: Nico
public class CostRequest {

    @JsonIgnore
    private double price;
    private int km;
    private int pallets;

    //getter and setter
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public int getKm() {
        return km;
    }
    public void setKm(int km) {
        this.km = km;
    }

    public int getPallets() {
        return pallets;
    }
    public void setPallets(int pallets) {
        this.pallets = pallets;
    }
}
