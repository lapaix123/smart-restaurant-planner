package com.restaurant.smart_restaurant_planner.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private Long employeeId;
    private String username;
    private String password;
    private String role; // Role is typically a string like "REGULAR_STAFF", "CONSULTANT", etc.
    private boolean isFingerprintEnabled;
    private FingerprintDTO fingerprint;
}
