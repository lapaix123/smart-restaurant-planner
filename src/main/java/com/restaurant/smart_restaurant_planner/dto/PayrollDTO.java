package com.restaurant.smart_restaurant_planner.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PayrollDTO {

    private Long id;
    private Long employeeId;
    private String employeeName;
    private double grossSalary;
    private double deductions;
    private double netSalary;
    private LocalDate payrollDate;
}
