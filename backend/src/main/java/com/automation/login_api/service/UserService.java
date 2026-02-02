package com.automation.login_api.service;

import com.automation.login_api.model.User;
import com.automation.login_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Check if the username is already taken
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null) {
            // We throw an exception so the Controller can catch it and send a 409 Conflict
            throw new RuntimeException("User already exists with username: " + user.getUsername());
        }

        // If we get here, it means the user is new
        return userRepository.save(user);
    }

    public Boolean loginUser(User user){
        User foundUser = userRepository.findByUsername(user.getUsername());

        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
