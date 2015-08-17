package com.autentia.concesionario.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autentia.concesionario.model.Car;
import com.autentia.concesionario.services.CarColourService;
import com.autentia.concesionario.services.CarService;

@ManagedBean(name = "carListController")
@ViewScoped
public class CarListController {

    private static final Logger LOG = LoggerFactory.getLogger(CarListController.class);

    @ManagedProperty("#{carService}")
    private CarService carService;

    @ManagedProperty("#{carColourService}")
    private CarColourService carColourService;

    private List<Car> carList = null;

    private List<Car> filterByColourCarList = null;

    private Car selectedCar = null;

    private List<String> colourNameList = null;

    @PostConstruct
    public void init() {
        LOG.info("Inicializando listado de coches...");
        loadCarList();
        loadColourNames();
        LOG.info("Listado inicializado.");
    }

    private void loadCarList() {
        LOG.info("Cargando lista de coches...");
        carList = carService.getAll();
        LOG.info("Hecho.");
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

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getFilterByColourCarList() {
        return filterByColourCarList;
    }

    public void setFilterByColourCarList(List<Car> filterByColourCarList) {
        this.filterByColourCarList = filterByColourCarList;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public List<String> getColourNameList() {
        return colourNameList;
    }

    public void setColourNameList(List<String> colourNameList) {
        this.colourNameList = colourNameList;
    }

    public void onRowSelect(SelectEvent event) {
        putSelectedDataInContext(event);

        if (selectedCar != null) {
            LOG.info("Seleccionado coche: {}", selectedCar.toString());
        }

        goToDetailPage();
    }

    protected void putSelectedDataInContext(SelectEvent event) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedCar", event.getObject());
    }

    private void goToDetailPage() {
        try {
            redirectToCarDetail();
            LOG.info("Vista de detalle cargada");
        } catch (final IOException e) {
            LOG.error("Fallo en navegación: {}", e);
        }
    }

    protected void redirectToCarDetail() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("cardetail.xhtml");
    }

}
