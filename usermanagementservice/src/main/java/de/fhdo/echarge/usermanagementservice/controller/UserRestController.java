package de.fhdo.echarge.usermanagementservice.controller;

import de.fhdo.echarge.usermanagementservice.entity.User;
import de.fhdo.echarge.usermanagementservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/resources/v1/userinterface", produces = "application/json")
public class UserRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
    private UserService userService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * REST endpoint for creating a user
     *
     * @param user User
     */
    @PutMapping(value = "/")
    public User createUser(@RequestBody User user) {
        LOGGER.info("Method: createUser");
        return userService.createUser(user);
    }

    /**
     * REST endpoint for updating a user
     *
     * @param user
     * @return created user with an autogenerated id
     */
    @PostMapping(value = "/")
    public User updateUser(@RequestBody User user) {
        LOGGER.info("Method: updateUser");
        return userService.updateUser(user);
    }

    /**
     * REST endpoint for reading a user with a specific id
     *
     * @param id String
     * @return User with the corresponding id
     */
    @GetMapping(value = "/id/{id}")
    public User readUser(@PathVariable("id") String id) {
        LOGGER.info("Method: readUser");
        return userService.readUser(id);
    }

    /**
     * REST endpoint for deleating a user with a specific id
     *
     * @param id String
     * @return TRUE/FALSE based on the success of the delete operation
     */

    @DeleteMapping(value = "/id/{id}")
    public boolean deleteUser(@PathVariable("id") String id) {
        LOGGER.info("Method: deleteUser");
        return userService.deleteUser(id);
    }

}
