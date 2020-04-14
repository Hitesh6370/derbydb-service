package com.transportsystem.derbyDB.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RouteDetail {

    private int route_id;
    private String planet_origin_id;
    private String planet_origin_name;
    private String planet_destination_id;
    private String planet_destination_name;
    private double distance;
    private double traffic_delay;

}
