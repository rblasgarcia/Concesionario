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
        final Car carToInsert = createSampleCar();
        carController.insertCar();
        Mockito.verify(mockedCarService, Mockito.times(1)).insert(carToInsert);
    }

    private void prepareCarControllerValues() {
        final Car car = createSampleCar();
        carController.setCar(car);
    }

    private Car createSampleCar() {
        final Car car = new Car();
        car.setBrand("Nisu");
        car.setModel("Puma");
        car.setYear(2015);
        car.setPower(250);
        car.setColour("Azul");
        car.setPrice(45000D);
        return car;
    }
}
