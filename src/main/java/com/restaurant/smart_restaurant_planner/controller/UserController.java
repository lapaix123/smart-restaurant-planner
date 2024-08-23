package com.restaurant.smart_restaurant_planner.controller;

import com.restaurant.smart_restaurant_planner.dto.UserDTO;
import com.restaurant.smart_restaurant_planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String username, @RequestParam String password) {
        boolean isValid = userService.validateUserCredentials(username, password);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/enable-fingerprint/{userId}")
    public ResponseEntity<Void> enableFingerprint(@PathVariable Long userId, @RequestParam boolean isEnabled) {
        userService.enableFingerprint(userId, isEnabled);
        return ResponseEntity.ok().build();
    }
}
