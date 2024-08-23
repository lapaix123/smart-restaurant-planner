package com.restaurant.smart_restaurant_planner.dto;

import lombok.Data;

@Data
public class InternshipExpenseDTO {

    private Long id;
    private Long internId;
    private String internName;
    private double expenseAmount;
    private String expenseCoveredBy;
    private boolean isApproved;
}
