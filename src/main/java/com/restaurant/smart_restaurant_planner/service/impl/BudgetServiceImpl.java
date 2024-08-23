package com.restaurant.smart_restaurant_planner.service.impl;

import com.restaurant.smart_restaurant_planner.dto.BudgetDTO;
import com.restaurant.smart_restaurant_planner.model.Budget;
import com.restaurant.smart_restaurant_planner.repository.BudgetRepository;
import com.restaurant.smart_restaurant_planner.service.BudgetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BudgetDTO> getAllBudgets() {
        return budgetRepository.findAll()
                .stream()
                .map(budget -> modelMapper.map(budget, BudgetDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BudgetDTO getBudgetById(Long id) {
        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
        return modelMapper.map(budget, BudgetDTO.class);
    }

    @Override
    public BudgetDTO addBudget(BudgetDTO budgetDTO) {
        Budget budget = modelMapper.map(budgetDTO, Budget.class);
        Budget savedBudget = budgetRepository.save(budget);
        return modelMapper.map(savedBudget, BudgetDTO.class);
    }

    @Override
    public BudgetDTO updateBudget(Long id, BudgetDTO budgetDTO) {
        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found"));
        modelMapper.map(budgetDTO, budget);
        Budget updatedBudget = budgetRepository.save(budget);
        return modelMapper.map(updatedBudget, BudgetDTO.class);
    }

    @Override
    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}
