package com.transportsystem.derbyDB.api.web.rest;

import com.transportsystem.derbyDB.api.domain.RouteDetail;
import com.transportsystem.derbyDB.api.persistence.entity.Planet;
import com.transportsystem.derbyDB.api.service.DBService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * The type Db controller.
 */
@RestController
@RequestMapping(value = "/api",
        produces = {
                APPLICATION_JSON_VALUE,
        })
@Tag(name = "transport system database", description = "The Transport System database API")
public class DBController {

    private final DBService DBService;

    /**
     * Instantiates a new Db controller.
     *
     * @param DBService the db service
     */
    @Autowired
    public DBController(final DBService DBService)
    {
        this.DBService = DBService;
    }


    /**
     * Test string.
     *
     * @return the string
     */
    @RequestMapping(value = "/test", method = GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String test()
    {
        return "all good";
    }

    /**
     * Get planets list.
     *
     * @return the list
     */
    @Operation(summary = "Planet list", description = "Find List of all planets which is present in system ", tags = { "planets" })
    @RequestMapping(value = "/planets", method = GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Planet>getPlanets()
    {
        return DBService.listAllPlanet();
    }

    /**
     * Get details list.
     *
     * @return the list
     */
    @Operation(summary = "Route Detail", description = "Find List of all routes along with distance and traffic delay  ", tags = { "details" })
    @RequestMapping(value = "/details", method = GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<RouteDetail>getDetails()
    {
        return DBService.routeDetails();
    }

}
