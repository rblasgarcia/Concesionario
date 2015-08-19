package com.autentia.concesionario.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.concesionario.model.Car;
import com.autentia.concesionario.services.CarService;

public class CarControllerTest {

    CarController carController;

    CarService mockedCarService = Mockito.mock(CarService.class);

    @Before
    public void setup() {

        carController = new CarController();
        carController.setCarService(mockedCarService);
        prepareCarControllerValues();
    }

    @Test
    public void shouldInsertANewCar() {
        final Car carToInsert = new Car("Nisu", "Puma", 2015, 250, "Azul", 45000);
        carController.insertCar();
        Mockito.verify(mockedCarService, Mockito.times(1)).insert(carToInsert);
    }

    private void prepareCarControllerValues() {
        carController.setCar(new Car("Nisu", "Puma", 2015, 250, "Azul", 45000));
    }

}
