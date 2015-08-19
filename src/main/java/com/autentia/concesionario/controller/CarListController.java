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
import com.autentia.concesionario.services.CarService;

@ManagedBean(name = "carListController")
@ViewScoped
public class CarListController {

    private static final Logger LOG = LoggerFactory.getLogger(CarListController.class);

    @ManagedProperty("#{carService}")
    private CarService carService;

    private List<Car> carList = null;

    private Car selectedCar = null;

    @PostConstruct
    public void init() {
        LOG.info("Inicializando listado de coches...");
        loadCarList();
        LOG.info("Listado inicializado.");
    }

    private void loadCarList() {
        LOG.info("Cargando lista de coches...");
        carList = carService.getAll();
        LOG.info("Hecho.");
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
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
