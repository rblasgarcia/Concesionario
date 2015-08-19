package com.autentia.concesionario.controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autentia.concesionario.model.Car;
import com.autentia.concesionario.services.CarService;

@ManagedBean(name = "carController")
@RequestScoped
public class CarController {

    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    @ManagedProperty("#{carService}")
    private CarService carService;

    @Valid
    private Car car;

    @PostConstruct
    public void init() {
        LOG.info("Formulario Cargado");
        car = new Car();
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String insertCar() {
        // el coche ya viene validado por la propia página
        // por eso no se controlan excepciones
        carService.insert(car);
        return "availablecars.xhtml";
    }

}
