package com.transportsystem.derbyDB.api.persistence.repository;
import com.transportsystem.derbyDB.api.persistence.entity.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Planet repository.
 */
@Repository
public interface PlanetRepository extends CrudRepository<Planet,Integer> {

    /**
     * Find planet name by planet node string.
     *
     * @param planetNode the planet node
     * @return the string
     */
    @Query(value = "select planetName from Planet where planetNode = ?1")
   String findPlanetNameByPlanetNode(String planetNode);
}
