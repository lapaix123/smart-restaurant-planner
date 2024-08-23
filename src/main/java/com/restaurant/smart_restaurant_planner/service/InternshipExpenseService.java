package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.InternshipExpenseDTO;

import java.util.List;

public interface InternshipExpenseService {
    List<InternshipExpenseDTO> getAllInternshipExpenses();
    InternshipExpenseDTO getInternshipExpenseById(Long id);
    InternshipExpenseDTO addInternshipExpense(InternshipExpenseDTO internshipExpenseDTO);
    InternshipExpenseDTO updateInternshipExpense(Long id, InternshipExpenseDTO internshipExpenseDTO);
    void deleteInternshipExpense(Long id);
    List<InternshipExpenseDTO> getInternshipExpensesByInternId(Long internId);
}