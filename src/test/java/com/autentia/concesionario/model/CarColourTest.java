package com.autentia.concesionario.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

public class CarColourTest {

    CarColour carColour;

    @Before
    public void setup() {
        carColour = new CarColour();
    }

    @Test
    public void testToString() {
        carColour.setColour("Amarillo");
        assertEquals("Color amarillo", carColour.toString());
    }

    @Test
    public void testEqualsObject() {

        final CarColour equalColour = new CarColour("Amarillo");
        final CarColour differentColour = new CarColour("Negro");
        carColour.setColour("Amarillo");

        assertEquals(equalColour, carColour);
        assertNotEquals(differentColour, carColour);
    }

}
