package com.autentia.concesionario.services;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.autentia.concesionario.dao.mappers.CarColourMapper;
import com.autentia.concesionario.model.CarColour;
import com.autentia.concesionario.services.impl.CarColourServiceImpl;

public class CarColourServiceTest {

    CarColourService carColourService;

    CarColourMapper mockedCarColourMapper = Mockito.mock(CarColourMapper.class);

    @Before
    public void setup() {
        carColourService = new CarColourServiceImpl(mockedCarColourMapper);
    }

    @Test
    public void shouldReturnSingleCarColour() {
        final CarColour sampleCarColour = createSampleCarColour();

        Mockito.when(mockedCarColourMapper.get(0)).thenReturn(sampleCarColour);

        final CarColour carColour = carColourService.get(0);

        assertEquals(sampleCarColour, carColour);

        Mockito.verify(mockedCarColourMapper, Mockito.times(1)).get(0);
    }

    @Test
    public void shouldReturnAllCarColourNames() {
        final List<String> sampleCarColourNames = createSampleCarColourNames();

        Mockito.when(mockedCarColourMapper.getAllCarColourNames()).thenReturn(sampleCarColourNames);

        final List<String> carColourNames = carColourService.getAllCarColourNames();

        assertEquals(sampleCarColourNames, carColourNames);

        Mockito.verify(mockedCarColourMapper, Mockito.times(1)).getAllCarColourNames();
    }

    private CarColour createSampleCarColour() {
        return new CarColour("Rojo");
    }

    private List<String> createSampleCarColourNames() {

        return Arrays.asList(createSampleCarColour().getColour());
    }
}
