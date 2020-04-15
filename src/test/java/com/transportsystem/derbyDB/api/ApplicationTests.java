package com.transportsystem.derbyDB.api;


import com.transportsystem.derbyDB.api.persistence.entity.Planet;
import com.transportsystem.derbyDB.api.persistence.entity.Route;
import com.transportsystem.derbyDB.api.service.DBService;
import com.transportsystem.derbyDB.api.web.rest.DBController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * The type Application tests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ApplicationTests {
    @Autowired
    private DBService dbService;

    /**
     * The Mock mvc.
     */
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private DBController dbController;

    /**
     * Test application load.
     */
    @Test
    public void testApplicationLoad()
    {
        assertNotNull("Controller is not loaded", dbController);
    }


    /**
     * Get planet test.
     */
    @Test
    public void getPlanetTest(){
        List planet = new ArrayList();
        planet.add(new Planet(101, "A", "Earth"));
        planet.add(new Planet( 102,"B","Moon"));
        planet.add(new Planet( 103,"C","Mars"));
        when(dbController.getPlanets()).thenReturn(planet);
        System.out.println(planet);
    }

    /**
     * Get route test.
     */
    @Test
    public void getRouteTest(){
        List route = new ArrayList();
        route.add(new Route(101,1,"A","c",10.00));
        route.add(new Route( 102,2,"B","D",20.00));
        when(dbController.getDetails()).thenReturn(route);
        System.out.println(route);
    }

}
