package de.fhdo.echarge.chargingpointservice.controller;

import de.fhdo.echarge.chargingpointservice.entity.ChargingPoint;
import de.fhdo.echarge.chargingpointservice.service.ChargingPointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5000")
public class ChargingPointRestController {
    private ChargingPointService chargingPointService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ChargingPointRestController.class);

    @Autowired
    public void setChargingPointService(ChargingPointService chargingPointService) {
        this.chargingPointService = chargingPointService;
    }

    /**
     * REST endpoint for reading all a ChargingPoint
     *
     * @return list of all available ChargingPoints
     */
    @GetMapping(value="/chargingPoints")
    public List<ChargingPoint> getAllChargingPoint() {
        LOGGER.info("Method: getChargingPoint");
        return chargingPointService.readAllChargingPoints();
    }

    /**
     * REST endpoint for creating a ChargingPoint
     *
     * @param chargingPoint ChargingPoint
     * @return persisted chargingPoint
     */
    @PostMapping(value="/chargingPoints")
    public ChargingPoint createChargingPoint(@RequestBody ChargingPoint chargingPoint) {
        LOGGER.info("Method: createChargingPoint");
        return chargingPointService.createChargingPoint(chargingPoint);
    }

    /**
     * REST endpoint for updating a ChargingPoint
     *
     * @param chargingPoint ChargingPoint
     * @return updated chargingPoint
     */
    @PostMapping(value = "/")
    public ChargingPoint updateChargingPoint(@RequestBody ChargingPoint chargingPoint) {
        LOGGER.info("Method: updateChargingPoint");
        return chargingPointService.updateChargingPoint(chargingPoint);
    }

    /**
     * REST endpoint for reading a ChargingPoint
     *
     * @param id of a ChargingPoint
     * @return requested chargingPoint with the corresponding id
     */
    @GetMapping(value = "/chargingPoints/{id}")
    public ChargingPoint getChargingPoint(@PathVariable String id) {
        LOGGER.info("Method: getChargingPoint");
        return chargingPointService.readChargingPoint(id);
    }

    /**
     * REST endpoint for deleting a ChargingPoint
     *
     * @param id of a ChargingPoint
     * @return TRUE/FALSE based on the success of the delete operation
     */
    @DeleteMapping(value = "/chargingPoints/{id}")
    public boolean deleteChargingPoint(@PathVariable String id) {
        LOGGER.info("Method: deleteChargingPoint");
        return chargingPointService.deleteChargingPoint(id);
    }
}
