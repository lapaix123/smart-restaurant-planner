package com.restaurant.smart_restaurant_planner.service.impl;

import com.restaurant.smart_restaurant_planner.dto.ExpenseDTO;
import com.restaurant.smart_restaurant_planner.model.Expense;
import com.restaurant.smart_restaurant_planner.repository.ExpenseRepository;
import com.restaurant.smart_restaurant_planner.service.ExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        return expenseRepository.findAll()
                .stream()
                .map(expense -> modelMapper.map(expense, ExpenseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        return modelMapper.map(expense, ExpenseDTO.class);
    }

    @Override
    public ExpenseDTO addExpense(ExpenseDTO expenseDTO) {
        Expense expense = modelMapper.map(expenseDTO, Expense.class);
        Expense savedExpense = expenseRepository.save(expense);
        return modelMapper.map(savedExpense, ExpenseDTO.class);
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        modelMapper.map(expenseDTO, expense);
        Expense updatedExpense = expenseRepository.save(expense);
        return modelMapper.map(updatedExpense, ExpenseDTO.class);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<ExpenseDTO> getExpensesByBudgetId(Long budgetId) {
        return expenseRepository.findByBudgetId(budgetId)
                .stream()
                .map(expense -> modelMapper.map(expense, ExpenseDTO.class))
                .collect(Collectors.toList());
    }
}
