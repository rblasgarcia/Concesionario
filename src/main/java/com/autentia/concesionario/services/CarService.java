package com.autentia.concesionario.services;

import java.util.List;

import com.autentia.concesionario.model.Car;

public interface CarService {

    public void insert(Car car);

    public Car get(int id);

    public List<Car> getAll();
}
