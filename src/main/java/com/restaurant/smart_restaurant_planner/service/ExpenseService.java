package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {
    List<ExpenseDTO> getAllExpenses();

    ExpenseDTO getExpenseById(Long id);

    ExpenseDTO addExpense(ExpenseDTO expenseDTO);

    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);

    List<ExpenseDTO> getExpensesByBudgetId(Long budgetId);
}