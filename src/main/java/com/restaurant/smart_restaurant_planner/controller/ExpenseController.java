package com.restaurant.smart_restaurant_planner.controller;

import com.restaurant.smart_restaurant_planner.dto.ExpenseDTO;
import com.restaurant.smart_restaurant_planner.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO createdExpense = expenseService.addExpense(expenseDTO);
        return ResponseEntity.ok(createdExpense);
    }

    @GetMapping("/budget/{budgetId}")
    public ResponseEntity<List<ExpenseDTO>> getExpensesByBudget(@PathVariable Long budgetId) {
        List<ExpenseDTO> expenses = expenseService.getExpensesByBudgetId(budgetId);
        return ResponseEntity.ok(expenses);
    }
}
