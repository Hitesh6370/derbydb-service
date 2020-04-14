package com.transportsystem.derbyDB.api.service;

import com.transportsystem.derbyDB.api.domain.RouteDetail;
import com.transportsystem.derbyDB.api.persistence.entity.Planet;
import com.transportsystem.derbyDB.api.persistence.entity.Route;
import com.transportsystem.derbyDB.api.persistence.entity.Traffic;

import java.util.List;

public interface DBService {

    List<Planet> listAllPlanet();

    List<RouteDetail> routeDetails();

    void savePlanetData(List<Planet> planets);

    void saveRoutsData(List<Route> routes);

    void saveTrafficData(List<Traffic> traffic);

    String getPlanetName(String pid);

}
