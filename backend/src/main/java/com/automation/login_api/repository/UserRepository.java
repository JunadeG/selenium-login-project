package com.automation.login_api.repository;

import com.automation.login_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username); // A custom method to find a user by their username
}
