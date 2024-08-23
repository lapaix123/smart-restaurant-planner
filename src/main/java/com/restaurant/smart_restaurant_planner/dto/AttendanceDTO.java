package com.restaurant.smart_restaurant_planner.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AttendanceDTO {

    private Long id;
    private Long employeeId;
    private String employeeName;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
}
