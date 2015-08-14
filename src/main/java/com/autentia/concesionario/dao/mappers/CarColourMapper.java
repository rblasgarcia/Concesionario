package com.autentia.concesionario.dao.mappers;

import java.util.List;

import com.autentia.concesionario.model.CarColour;

public interface CarColourMapper {

    public CarColour get(int id);

    public List<String> getAllCarColourNames();
}