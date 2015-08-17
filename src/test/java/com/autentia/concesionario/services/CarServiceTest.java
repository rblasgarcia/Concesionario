package com.autentia.concesionario.services;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.concesionario.dao.mappers.CarMapper;
import com.autentia.concesionario.model.Car;
import com.autentia.concesionario.services.impl.CarServiceImpl;

public class CarServiceTest {

    CarService carService;

    CarMapper mockedCarMapper = Mockito.mock(CarMapper.class);

    @Before
    public void setup() {
        carService = new CarServiceImpl(mockedCarMapper);
    }

    @Test
    public void shouldInsertACar() {
        final Car sampleCar = createSampleCar();

        carService.insert(sampleCar);

        Mockito.verify(mockedCarMapper, Mockito.times(1)).insert(sampleCar);
    }

    @Test
    public void shouldReturnSingleCar() {
        final Car sampleCar = createSampleCar();

        Mockito.when(mockedCarMapper.get(0)).thenReturn(sampleCar);

        final Car car = carService.get(0);

        assertEquals(sampleCar, car);

        Mockito.verify(mockedCarMapper, Mockito.times(1)).get(0);
    }

    @Test
    public void shouldReturnAllCars() {
        final List<Car> sampleCarList = createSampleCarList();

        Mockito.when(mockedCarMapper.getAll()).thenReturn(sampleCarList);

        final List<Car> carList = carService.getAll();

        assertEquals(sampleCarList, carList);

        Mockito.verify(mockedCarMapper, Mockito.times(1)).getAll();
    }

    private Car createSampleCar() {
        return new Car("Renault", "Clio", 2011, 100, "Rojo", 11300);
    }

    private List<Car> createSampleCarList() {

        return Arrays.asList(createSampleCar());
    }
}
