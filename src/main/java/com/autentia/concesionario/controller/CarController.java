package com.autentia.concesionario.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autentia.concesionario.model.Car;
import com.autentia.concesionario.services.CarColourService;
import com.autentia.concesionario.services.CarService;

@ManagedBean(name = "carController")
@RequestScoped
public class CarController {

    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    @ManagedProperty("#{carColourService}")
    private CarColourService carColourService;

    @ManagedProperty("#{carService}")
    private CarService carService;

    private List<String> colourNameList = null;

    @Valid
    private Car car;

    @PostConstruct
    public void init() {
        LOG.info("Inicializando formulario...");
        loadColourNames();
        LOG.info("Formulario inicializado.");
        car = new Car();
    }

    public CarColourService getCarColourService() {
        return carColourService;
    }

    public void setCarColourService(CarColourService carColourService) {
        this.carColourService = carColourService;
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public List<String> getColourNameList() {
        return colourNameList;
    }

    public void setColourNameList(List<String> colourNameList) {
        this.colourNameList = colourNameList;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    private void loadColourNames() {
        LOG.info("Cargando lista de colores...");
        colourNameList = carColourService.getAllCarColourNames();
        LOG.info("Hecho.");
    }

    public void insertCar() {
        // el coche ya viene validado por la propia página
        // por eso no se controlan excepciones
        carService.insert(car);
    }

}
