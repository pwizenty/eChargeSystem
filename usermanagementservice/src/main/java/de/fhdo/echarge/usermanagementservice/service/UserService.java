package de.fhdo.echarge.usermanagementservice.service;

import de.fhdo.echarge.usermanagementservice.entity.User;

public interface UserService {
    User createUser(User user);

    User updateUser(User user);

    User readUser(String id);

    boolean deleteUser(String id);
}