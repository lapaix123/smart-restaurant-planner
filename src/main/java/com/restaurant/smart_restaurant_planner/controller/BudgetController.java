package com.restaurant.smart_restaurant_planner.controller;

import com.restaurant.smart_restaurant_planner.dto.BudgetDTO;
import com.restaurant.smart_restaurant_planner.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @PostMapping("/create")
    public ResponseEntity<BudgetDTO> createBudget(@RequestBody BudgetDTO budgetDTO) {
        BudgetDTO createdBudget = budgetService.addBudget(budgetDTO);
        return ResponseEntity.ok(createdBudget);
    }

    @GetMapping
    public ResponseEntity<List<BudgetDTO>> getAllBudgets() {
        List<BudgetDTO> budgets = budgetService.getAllBudgets();
        return ResponseEntity.ok(budgets);
    }
}
