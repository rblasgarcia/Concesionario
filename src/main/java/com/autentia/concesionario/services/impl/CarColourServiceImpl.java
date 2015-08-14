package com.autentia.concesionario.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.concesionario.dao.mappers.CarColourMapper;
import com.autentia.concesionario.model.CarColour;
import com.autentia.concesionario.services.CarColourService;
import com.autentia.concesionario.services.CarService;

@Service("carColourService")
public class CarColourServiceImpl implements CarColourService {

    private static final Logger LOG = LoggerFactory.getLogger(CarService.class);

    private final CarColourMapper carColourMapper;

    @Autowired
    public CarColourServiceImpl(CarColourMapper carColourMapper) {
        this.carColourMapper = carColourMapper;
    }

    @Override
    public CarColour get(int id) {
        LOG.info("Getting CarColour with Id: {}", id);
        return carColourMapper.get(id);
    }

    @Override
    public List<String> getAllCarColourNames() {
        LOG.info("Getting all CarColour names");
        return carColourMapper.getAllCarColourNames();
    }

}
