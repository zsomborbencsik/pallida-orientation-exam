package com.greenfox.orientationexam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LicencePlates {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String plate;
    String carBrand;
    String carModel;
    String color;
    int year;

    public LicencePlates(String plate, String carBrand, String carModel, String color, int year) {
        this.plate = plate;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.color = color;
        this.year = year;
    }

    public LicencePlates() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
