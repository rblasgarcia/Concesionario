package com.autentia.concesionario.services;

import java.util.List;

import com.autentia.concesionario.model.CarColour;

public interface CarColourService {

    public CarColour get(int id);

    public List<String> getAllCarColourNames();
}
