package de.fhdo.echarge.environmentservice.controller;

import de.fhdo.echarge.environmentservice.entity.EnvironmentInfo;
import de.fhdo.echarge.environmentservice.service.EnvironmentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/resources/v1/environmentinfointerface", produces = "application/json")
public class EnvironmentInfoRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnvironmentInfoRestController.class);
    private EnvironmentInfoService environmentInfoService;

    @Autowired
    public void setEnvironmentInfoService(EnvironmentInfoService environmentInfoService) {
        this.environmentInfoService = environmentInfoService;
    }

    /**
     * REST endpoint for reading All a EnvironmentInfo
     *
     * @return List of EnvironmentInfos
     */
    @GetMapping(value = "/")
    public List<EnvironmentInfo> getAllEnvironmentInfo() {
        LOGGER.info("Method: getAllEnvironmentInfo");
        return environmentInfoService.readAllEnvironmentInfos();
    }

    /**
     * REST endpoint for creating a EnvironmentInfo
     *
     * @param environmentInfo EnvironmentInfo
     * @return created environmentInfo with assigned id
     */
    @PutMapping(value = "/")
    public EnvironmentInfo createEnvironmentInfo(@RequestBody EnvironmentInfo environmentInfo) {
        LOGGER.info("Method: createEnvironmentInfo");
        return environmentInfoService.createEnvironmentInfo(environmentInfo);
    }

    /**
     * REST endpoint for updating a EnvironmentInfo
     *
     * @param environmentInfo EnvironmentInfo
     * @return updated EnvironmentInfo
     */
    @PostMapping(value = "/")
    public EnvironmentInfo updateEnvironmentInfo(@RequestBody EnvironmentInfo environmentInfo) {
        LOGGER.info("Method: updateEnvironmentInfo");
        return environmentInfoService.updateEnvironmentInfo(environmentInfo);
    }

    /**
     * REST endpoint for reading a EnvironmentInfo with an specific id
     *
     * @param id String id od the EnvironmentInfo
     * @return EnvironmentInfo with the specific id
     */
    @GetMapping(value = "/id/{id}")
    public EnvironmentInfo getEnvironmentInfo(@PathVariable("id") String id) {
        LOGGER.info("Method: getEnvironmentInfo");
        return environmentInfoService.readEnvironmentInfo(id);
    }

    /**
     * REST endpoint for deleting a EnvironmentInfo with an specific id
     *
     * @param id String of the EnvironmentInfo
     * @return TRUE/FALSE based on the success of the delete operation
     */
    @DeleteMapping(value = "/id/{id}")
    public String deleteEnvironmentInfo(@PathVariable("id") String id) {
        LOGGER.info("Method: deleteEnvironmentInfo");
        environmentInfoService.deleteEnvironmentInfo(id);
        return id;
    }
}
