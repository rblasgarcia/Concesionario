package com.autentia.concesionario.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.concesionario.model.Car;
import com.autentia.concesionario.services.CarColourService;
import com.autentia.concesionario.services.CarService;

public class CarControllerTest {

    CarController carController;

    CarService mockedCarService = Mockito.mock(CarService.class);

    CarColourService mockedCarColourService = Mockito.mock(CarColourService.class);

    @Before
    public void setup() {
        mockServiceMethods();

        carController = new CarController();
        carController.setCarService(mockedCarService);
        carController.setCarColourService(mockedCarColourService);
        prepareCarControllerValues();
    }

    @Test
    public void shouldInitializeValues() {
        carController.init();
        assertNotNull(carController.getColourNameList());
        Mockito.verify(mockedCarColourService, Mockito.times(1)).getAllCarColourNames();
    }

    @Test
    public void shouldInsertANewCar() {
        final Car carToInsert = new Car("Nisu", "Puma", 2015, 250, "Azul", 45000);
        carController.insertCar();
        Mockito.verify(mockedCarService, Mockito.times(1)).insert(carToInsert);
    }

    private void mockServiceMethods() {
        Mockito.when(mockedCarColourService.getAllCarColourNames()).thenReturn(new ArrayList<String>());
    }

    private void prepareCarControllerValues() {
        carController.setBrand("Nisu");
        carController.setModel("Puma");
        carController.setYear(2015);
        carController.setPower(250);
        carController.setColour("Azul");
        carController.setPrice(45000D);
    }

}
