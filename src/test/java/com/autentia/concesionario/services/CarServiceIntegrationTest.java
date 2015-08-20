package com.autentia.concesionario.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.autentia.concesionario.model.Car;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml",
        "classpath:applicationContext-test.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class CarServiceIntegrationTest {

    @Autowired
    CarService carService;

    @Test
    public void shouldInsertACar() {
        final Car carToInsert = createSampleCar();

        final int previousSize = getNumberOfCars();

        carService.insert(carToInsert);

        final int currentSize = getNumberOfCars();

        assertEquals(previousSize + 1, currentSize);

    }

    @Test
    public void shouldGetSingleCar() {

        final Car retrievedCar = carService.get(1);
        assertNotNull(retrievedCar);

        assertEquals(1, retrievedCar.getId());
        assertEquals("Renault", retrievedCar.getBrand());
        assertEquals("Clio", retrievedCar.getModel());
        assertEquals(Integer.valueOf(2011), retrievedCar.getYear());
        assertEquals(Integer.valueOf(100), retrievedCar.getPower());
        assertEquals("Negro", retrievedCar.getColour());
        assertEquals(Double.valueOf(11300), retrievedCar.getPrice());
    }

    @Test
    public void shouldReturnAllCars() {
        final List<Car> carList = carService.getAll();
        assertFalse(carList.isEmpty());
        assertEquals(4, carList.size());
    }

    private int getNumberOfCars() {

        return carService.getAll().size();
    }

    private Car createSampleCar() {
        final Car car = new Car();
        car.setBrand("Renault");
        car.setModel("Clio");
        car.setYear(2012);
        car.setPower(100);
        car.setColour("Amarillo");
        car.setPrice(11300D);
        return car;
    }

}
