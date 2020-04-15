package com.transportsystem.derbyDB.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Route detail.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RouteDetail {

    private int routeId;
    private String planetOriginNode;
    private String planetOriginName;
    private String planetDestinationNode;
    private String planetDestinationName;
    private double distance;
    private double trafficDelay;



}
