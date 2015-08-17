package com.autentia.concesionario.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.autentia.concesionario.model.CarColour;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml",
        "classpath:applicationContext-test.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class CarColourServiceIntegrationTest {

    @Autowired
    CarColourService carColourService;

    @Test
    public void shouldGetSingleColour() {

        final CarColour retrievedColour = carColourService.get(1);
        assertNotNull(retrievedColour);

        assertEquals(1, retrievedColour.getId());
        assertEquals("Negro", retrievedColour.getColour());
    }

    @Test
    public void shouldReturnAllColours() {
        final List<String> carColourNameList = carColourService.getAllCarColourNames();
        assertFalse(carColourNameList.isEmpty());
        assertEquals(10, carColourNameList.size());
    }

}
