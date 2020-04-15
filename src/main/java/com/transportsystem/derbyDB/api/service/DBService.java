package com.transportsystem.derbyDB.api.service;

import com.transportsystem.derbyDB.api.domain.RouteDetail;
import com.transportsystem.derbyDB.api.persistence.entity.Planet;
import com.transportsystem.derbyDB.api.persistence.entity.Route;
import com.transportsystem.derbyDB.api.persistence.entity.Traffic;

import java.util.List;

/**
 * The interface Db service.
 */
public interface DBService {

    /**
     * List all planet list.
     *
     * @return the list
     */
    List<Planet> listAllPlanet();

    /**
     * Route details list.
     *
     * @return the list
     */
    List<RouteDetail> routeDetails();

    /**
     * Save planet data.
     *
     * @param planets the planets
     */
    void savePlanetData(List<Planet> planets);

    /**
     * Save routs data.
     *
     * @param routes the routes
     */
    void saveRoutsData(List<Route> routes);

    /**
     * Save traffic data.
     *
     * @param traffic the traffic
     */
    void saveTrafficData(List<Traffic> traffic);

    /**
     * Gets planet name.
     *
     * @param pid the pid
     * @return the planet name
     */
    String getPlanetName(String pid);

}
