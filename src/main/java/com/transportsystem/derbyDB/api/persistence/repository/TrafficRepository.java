package com.transportsystem.derbyDB.api.persistence.repository;

import com.transportsystem.derbyDB.api.persistence.entity.Traffic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrafficRepository extends CrudRepository<Traffic, Integer> {

    Traffic findByRouteid(int s);
}
