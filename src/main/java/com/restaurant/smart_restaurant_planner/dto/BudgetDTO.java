package com.restaurant.smart_restaurant_planner.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BudgetDTO {

    private Long id;
    private double totalBudget;
    private double allocatedBudget;
    private double remainingBudget;
    private LocalDate budgetStartDate;
    private LocalDate budgetEndDate;
    private List<ExpenseDTO> expenses;
}
