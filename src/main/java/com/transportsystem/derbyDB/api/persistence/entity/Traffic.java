package com.transportsystem.derbyDB.api.persistence.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * The type Traffic.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Traffic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="route_id")
    private int routeId;

    @Column(name="planet_origin")
    private String planetOriginNode;

    @Column(name="planet_destination")
    private String planetDestinationNode;

    @Column(name="traffic_delay")
    private double trafficDelay;

}
