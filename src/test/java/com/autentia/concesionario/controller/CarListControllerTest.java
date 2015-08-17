package com.autentia.concesionario.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.concesionario.model.Car;
import com.autentia.concesionario.services.CarColourService;
import com.autentia.concesionario.services.CarService;

public class CarListControllerTest {

    CarListController carListController;

    CarService mockedCarService = Mockito.mock(CarService.class);

    CarColourService mockedCarColourService = Mockito.mock(CarColourService.class);

    @Before
    public void setup() {
        mockServiceMethods();

        carListController = new CarListController();
        carListController.setCarService(mockedCarService);
        carListController.setCarColourService(mockedCarColourService);
    }

    @Test
    public void shouldInitializeValues() {
        carListController.init();

        assertNotNull(carListController.getCarList());
        assertNotNull(carListController.getColourNameList());
        Mockito.verify(mockedCarService, Mockito.times(1)).getAll();
        Mockito.verify(mockedCarColourService, Mockito.times(1)).getAllCarColourNames();
    }

    private void mockServiceMethods() {
        Mockito.when(mockedCarService.getAll()).thenReturn(new ArrayList<Car>());
        Mockito.when(mockedCarColourService.getAllCarColourNames()).thenReturn(new ArrayList<String>());
    }

}
