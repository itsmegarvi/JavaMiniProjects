package com.mis.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    private long laptopID;
    private String laptopBrand;
    private String model;


    public Laptop(long laptopID, String laptopBrand, String model) {
        this.laptopID = laptopID;
        this.laptopBrand = laptopBrand;
        this.model = model;
    }

    public Laptop(){

    }

    public String getLaptopBrand() {
        return laptopBrand;
    }

    public void setLaptopBrand(String laptopBrand) {
        this.laptopBrand = laptopBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getLaptopID() {
        return laptopID;
    }

    public void setLaptopID(long laptopID) {
        this.laptopID = laptopID;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopID=" + laptopID +
                ", laptopBrand='" + laptopBrand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
