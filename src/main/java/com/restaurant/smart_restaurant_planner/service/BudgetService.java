package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.BudgetDTO;

import java.util.List;

public interface BudgetService {
    List<BudgetDTO> getAllBudgets();
    BudgetDTO getBudgetById(Long id);
    BudgetDTO addBudget(BudgetDTO budgetDTO);
    BudgetDTO updateBudget(Long id, BudgetDTO budgetDTO);
    void deleteBudget(Long id);
}