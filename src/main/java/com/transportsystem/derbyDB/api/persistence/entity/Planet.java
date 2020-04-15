package com.transportsystem.derbyDB.api.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type Planet.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;

    @Column(name="planet_node")
    private String planetNode;

    @Column(name="planet_name")
    private String planetName;

}
