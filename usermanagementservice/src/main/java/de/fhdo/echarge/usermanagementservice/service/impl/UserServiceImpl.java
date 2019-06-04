package de.fhdo.echarge.usermanagementservice.service.impl;

import de.fhdo.echarge.usermanagementservice.entity.User;
import de.fhdo.echarge.usermanagementservice.repository.UserRepository;
import de.fhdo.echarge.usermanagementservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User readUser(String id) {
        return userRepository.findById(id).orElseGet(null);
    }

    @Override
    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.delete(userRepository.findById(id).get());
            return true;
        }
        return false;
    }
}
