package com.transportsystem.derbyDB.api.service;


import com.transportsystem.derbyDB.api.domain.RouteDetail;
import com.transportsystem.derbyDB.api.persistence.entity.Planet;
import com.transportsystem.derbyDB.api.persistence.entity.Route;
import com.transportsystem.derbyDB.api.persistence.entity.Traffic;
import com.transportsystem.derbyDB.api.persistence.repository.PlanetRepository;
import com.transportsystem.derbyDB.api.persistence.repository.RouteRepository;
import com.transportsystem.derbyDB.api.persistence.repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Db service.
 */
@Service
public class DBServiceImpl implements DBService {

    private final PlanetRepository planetRepository;
    private final RouteRepository routeRepository;
    private final TrafficRepository trafficRepository;

    /**
     * Instantiates a new Db service.
     *
     * @param planetRepository  the planet repository
     * @param routeRepository   the route repository
     * @param trafficRepository the traffic repository
     */
    @Autowired
    public DBServiceImpl(final PlanetRepository planetRepository, final RouteRepository routeRepository, final TrafficRepository trafficRepository)
    {
        this.planetRepository=planetRepository;
        this.routeRepository=routeRepository;
        this.trafficRepository=trafficRepository;
    }

    @Override
    public List<Planet> listAllPlanet()
    {
        List<Planet> planets = new ArrayList<>();
        planetRepository.findAll().forEach(planets::add);
        return planets;
    }

    @Override
    public String getPlanetName(String pid)
    {
        return planetRepository.findPlanetNameByPlanetNode(pid);
    }

    @Override
    public List<RouteDetail> routeDetails()
    {
        List<RouteDetail> routeDetails = new ArrayList<>();
        List<Route> routes = new ArrayList<>();
        routeRepository.findAll().forEach(routes::add);

        for (Route route : routes)
        {
            RouteDetail routeDetail = new RouteDetail();
            routeDetail.setRouteId(route.getRouteId());
            routeDetail.setPlanetOriginNode(route.getPlanetOriginNode());
            routeDetail.setPlanetOriginName(getPlanetName(route.getPlanetOriginNode()));
            routeDetail.setPlanetDestinationNode(route.getPlanetDestinationNode());
            routeDetail.setPlanetDestinationName(getPlanetName(route.getPlanetDestinationNode()));
            routeDetail.setDistance(route.getDuration());
            Traffic traffic = trafficRepository.findByRouteId(route.getRouteId());
            routeDetail.setTrafficDelay(traffic.getTrafficDelay());
            routeDetails.add(routeDetail);
        }
        return routeDetails;
    }


    @Override
    public void savePlanetData(List<Planet> planetList) {
        for(Planet planet : planetList) { planetRepository.save(planet); }
    }

    @Override
    public void saveRoutsData(List<Route> routes) {
        for(Route route : routes) { routeRepository.save(route); }
    }

    @Override
    public void saveTrafficData(List<Traffic> traffic) {
        for(Traffic t : traffic) { trafficRepository.save(t); }
    }

}
