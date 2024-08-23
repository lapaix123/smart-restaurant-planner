package com.restaurant.smart_restaurant_planner.dto;

import lombok.Data;

@Data
public class EmployeeDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String role;
    private double salary;
}
