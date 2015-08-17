package com.autentia.concesionario.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autentia.concesionario.model.Car;
import com.autentia.concesionario.services.CarColourService;
import com.autentia.concesionario.services.CarService;

@ManagedBean(name = "carController")
@RequestScoped
public class CarController {

    private static final Logger LOG = LoggerFactory.getLogger(CarController.class);

    @ManagedProperty("#{carService}")
    private CarService carService;

    @ManagedProperty("#{carColourService}")
    private CarColourService carColourService;

    private List<String> colourNameList = null;

    private String brand;

    private String model;

    private Integer year;

    private Integer power;

    private String colour;

    private Double price;

    @PostConstruct
    public void init() {
        LOG.info("Inicializando formulario...");
        loadColourNames();
        LOG.info("Formulario inicializado.");
    }

    private void loadColourNames() {
        LOG.info("Cargando lista de colores...");
        colourNameList = carColourService.getAllCarColourNames();
        LOG.info("Hecho.");
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public CarColourService getCarColourService() {
        return carColourService;
    }

    public void setCarColourService(CarColourService carColourService) {
        this.carColourService = carColourService;
    }

    public List<String> getColourNameList() {
        return colourNameList;
    }

    public void setColourNameList(List<String> colourNameList) {
        this.colourNameList = colourNameList;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void insertCar() {
        // el coche ya viene validado por la propia página
        // por eso no se controlan excepciones
        final Car carToInsert = new Car(brand, model, year, power, colour, price);
        carService.insert(carToInsert);
    }

}
