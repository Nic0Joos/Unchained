package com.unchained.Unchained.Data.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    private String street;
    private int zipcode;
    private int city;
    @Email
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    //getter and setter
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public int getZipcode() { return zipcode; }
    public void setZipcode(int zipcode) { this.zipcode = zipcode; }

    public int getCity() { return city; }
    public void setCity(int city) { this.city = city; }

    public String getPassword() {
        String transientPassword = this.password;
        this.password = null;
        return transientPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
