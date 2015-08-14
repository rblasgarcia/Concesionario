package com.autentia.concesionario.dao.mappers;

import java.util.List;

import com.autentia.concesionario.model.Car;

public interface CarMapper {

    public void insert(Car car);

    public Car get(int id);

    public List<Car> getAll();

}
