package com.autentia.concesionario.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Car {

    private int id;

    private String brand;

    private String model;

    private Integer year;

    private Integer power;

    private String colour;

    private Double price;

    public Car() {
    };

    public Car(String brand, String model, int year, int power, String colour, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.power = power;
        this.colour = colour;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return brand + " " + model + ", año " + year + ", " + power + "CV, color " + colour.toLowerCase() + ". Precio: "
                + price + "€";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        final Car other = (Car)o;

        final boolean ret = new EqualsBuilder().append(this.id, other.getId()).append(this.brand, other.getBrand())
                .append(this.model, other.getModel()).append(this.year, other.getYear())
                .append(this.power, other.getPower()).append(this.colour, other.getColour())
                .append(this.price, other.getPrice()).isEquals();

        return ret;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).append(this.brand).append(this.model).append(this.year)
                .append(this.power).append(this.colour).append(this.price).hashCode();
    }
}
