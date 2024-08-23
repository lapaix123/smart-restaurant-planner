package com.restaurant.smart_restaurant_planner.service.impl;

import com.restaurant.smart_restaurant_planner.dto.UserDTO;
import com.restaurant.smart_restaurant_planner.model.User;
import com.restaurant.smart_restaurant_planner.repository.UserRepository;
import com.restaurant.smart_restaurant_planner.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt the password
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    @Override
    public Optional<UserDTO> findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(user -> modelMapper.map(user, UserDTO.class));
    }

    @Override
    public void enableFingerprint(Long userId, boolean isEnabled) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setFingerprintEnabled(isEnabled);
        userRepository.save(user);
    }

    @Override
    public boolean validateUserCredentials(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return passwordEncoder.matches(password, user.getPassword());
    }
}
