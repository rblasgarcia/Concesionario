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

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
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

    public void setPrice(Double price) {
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

        return new EqualsBuilder().append(this.id, other.getId()).append(this.brand, other.getBrand())
                .append(this.model, other.getModel()).append(this.year, other.getYear())
                .append(this.power, other.getPower()).append(this.colour, other.getColour())
                .append(this.price, other.getPrice()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).append(this.brand).append(this.model).append(this.year)
                .append(this.power).append(this.colour).append(this.price).hashCode();
    }
}
