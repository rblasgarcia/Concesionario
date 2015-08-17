package com.autentia.concesionario.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class CarColour {

    private int id;

    private String colour;

    public CarColour() {
    };

    public CarColour(String colour) {
        this.colour = colour;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Color " + colour.toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CarColour)) {
            return false;
        }

        final CarColour other = (CarColour)o;
        return new EqualsBuilder().append(this.colour, other.getColour()).isEquals();

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.colour).hashCode();
    }

}
