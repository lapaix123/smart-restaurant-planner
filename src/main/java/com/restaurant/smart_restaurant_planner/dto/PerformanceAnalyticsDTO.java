package com.restaurant.smart_restaurant_planner.dto;

import lombok.Data;

@Data
public class PerformanceAnalyticsDTO {

    private Long id;
    private Long employeeId;
    private String employeeName;
    private double attendanceScore;
    private double productivityScore;
    private double overallPerformanceScore;
}
