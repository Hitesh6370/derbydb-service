package com.transportsystem.derbyDB.api.persistence.repository;

import com.transportsystem.derbyDB.api.persistence.entity.Traffic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Traffic repository.
 */
@Repository
public interface TrafficRepository extends CrudRepository<Traffic, Integer> {

    /**
     * Find by route id traffic.
     *
     * @param s the s
     * @return the traffic
     */
    Traffic findByRouteId(int s);
}
