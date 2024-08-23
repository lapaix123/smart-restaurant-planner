package com.restaurant.smart_restaurant_planner.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShiftScheduleDTO {

    private Long id;
    private Long employeeId;
    private String employeeName;
    private LocalDateTime shiftStartTime;
    private LocalDateTime shiftEndTime;
    private String shiftType;
    private boolean isActive;
}
