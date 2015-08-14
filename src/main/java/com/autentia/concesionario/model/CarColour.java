package com.autentia.concesionario.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class CarColour {

    private int id;

    private String colourName;

    public CarColour(String colourName) {
        this.colourName = colourName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    @Override
    public String toString() {
        return "Color " + colourName;
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
        return new EqualsBuilder().append(this.colourName, other.getColourName()).isEquals();

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.colourName).hashCode();
    }

}
