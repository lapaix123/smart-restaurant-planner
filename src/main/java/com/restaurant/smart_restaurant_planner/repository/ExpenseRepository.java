package com.restaurant.smart_restaurant_planner.repository;

import com.restaurant.smart_restaurant_planner.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByBudgetId(Long budgetId);
}