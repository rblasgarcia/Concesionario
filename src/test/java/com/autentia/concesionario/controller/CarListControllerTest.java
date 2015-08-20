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

    @Before
    public void setup() {
        mockServiceMethods();

        carListController = new CarListControllerStub();
        carListController.setCarService(mockedCarService);
    }

    @Test
    public void shouldInitializeValues() {
        carListController.init();

        assertNotNull(carListController.getCarList());
        Mockito.verify(mockedCarService, Mockito.times(1)).getAll();
    }

    @Test
    public void shouldRedirectToDetailPageWithoutSelectedCar() {
        assertOKOnRowSelected();
    }

    @Test
    public void shouldRedirectToDetailPageWithSelectedCar() {
        carListController.setSelectedCar(createSampleCar());
        assertOKOnRowSelected();
    }

    private void mockServiceMethods() {
        Mockito.when(mockedCarService.getAll()).thenReturn(new ArrayList<Car>());
    }

    private void assertOKOnRowSelected() {
        carListController.onRowSelect(null);
        assertTrue(carListController.isFacesContextCalled());
        assertTrue(carListController.isdataInContextPut());
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
