package com.transportsystem.derbyDB.api.persistence.repository;

import com.transportsystem.derbyDB.api.persistence.entity.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends CrudRepository<Route, Integer> {
}
