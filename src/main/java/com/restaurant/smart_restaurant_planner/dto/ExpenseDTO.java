package com.restaurant.smart_restaurant_planner.dto;


import lombok.Data;

@Data
public class ExpenseDTO {

    private Long id;
    private String expenseName;
    private double amount;
    private String expenseType;
    private Long budgetId;
}
