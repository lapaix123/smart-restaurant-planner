package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.UserDTO;

import java.util.Optional;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    Optional<UserDTO> findUserByUsername(String username);
    void enableFingerprint(Long userId, boolean isEnabled);
    boolean validateUserCredentials(String username, String password);
}
