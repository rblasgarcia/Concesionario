package com.autentia.concesionario.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.primefaces.event.SelectEvent;

import com.autentia.concesionario.model.Car;
import com.autentia.concesionario.services.CarColourService;
import com.autentia.concesionario.services.CarService;

public class CarListControllerTest {

    class CarListControllerStub extends CarListController {

        boolean facesContextCalled = false;

        boolean dataInContextPut = false;

        public boolean isFacesContextCalled() {
            return facesContextCalled;
        }

        public boolean isdataInContextPut() {
            return dataInContextPut;
        }

        @Override
        protected void redirectToCarDetail() throws IOException {
            facesContextCalled = true;
        }

        @Override
        protected void putSelectedDataInContext(SelectEvent event) {
            dataInContextPut = true;
        }

    }

    CarListControllerStub carListController;

    CarService mockedCarService = Mockito.mock(CarService.class);

    CarColourService mockedCarColourService = Mockito.mock(CarColourService.class);

    @Before
    public void setup() {
        mockServiceMethods();

        carListController = new CarListControllerStub();
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

    @Test
    public void shouldRedirectToDetailPageWithoutSelectedCar() {
        assertOKOnRowSelected();
    }

    @Test
    public void shouldRedirectToDetailPageWithSelectedCar() {
        carListController.setSelectedCar(new Car("Renault", "Clio", 2012, 100, "Amarillo", 11300));
        assertOKOnRowSelected();
    }

    private void mockServiceMethods() {
        Mockito.when(mockedCarService.getAll()).thenReturn(new ArrayList<Car>());
        Mockito.when(mockedCarColourService.getAllCarColourNames()).thenReturn(new ArrayList<String>());
    }

    private void assertOKOnRowSelected() {
        carListController.onRowSelect(null);
        assertTrue(carListController.isFacesContextCalled());
        assertTrue(carListController.isdataInContextPut());
    }

}
