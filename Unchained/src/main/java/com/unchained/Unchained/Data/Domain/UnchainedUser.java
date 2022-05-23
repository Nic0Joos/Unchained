package com.unchained.Unchained.Data.Domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.List;

//Author: Alex Herzog
@Entity
public class UnchainedUser {

    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    private String street;
    private String zipCode;
    private String city;
    private int travelDistance;
    @Email
    private String email;
    private boolean isAnAdmin;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    public UnchainedUser(){}


    public UnchainedUser(Long userId, String name, String street, String zipCode, String city, int travelDistance, String email, boolean isAnAdmin, String password) {
        this.userId = userId;
        this.name = name;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.travelDistance = travelDistance;
        this.email = email;
        this.isAnAdmin = isAnAdmin;
        this.password = password;
    }


    public UnchainedUser(String name, String street, String zipCode, String city, int travelDistance, String email, boolean isAnAdmin, String password) {
        this.name = name;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.travelDistance = travelDistance;
        this.email = email;
        this.isAnAdmin = isAnAdmin;
        this.password = password;
    }


    public UnchainedUser(String name, String street, String zipCode, String city, String email, boolean isAnAdmin, String password) {
        this.name = name;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.email = email;
        this.isAnAdmin = isAnAdmin;
        this.password = password;
    }



    //getter and setter
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getZipCode() {
        return zipCode;
    }
    public void setZIPCode(String ZIPCode) {
        this.zipCode = ZIPCode;
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public int getTraveldistance() {
        return travelDistance;
    }
    public void setTraveldistance(int travelDistance) {
        this.travelDistance = travelDistance;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        String transientPassword = this.password;
        this.password = null;
        return transientPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAnAdmin() {
        return isAnAdmin;
    }

    public void setAnAdmin(boolean anAdmin) {
        isAnAdmin = anAdmin;
    }
}
