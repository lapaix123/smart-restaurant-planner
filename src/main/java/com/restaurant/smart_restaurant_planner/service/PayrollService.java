package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.PayrollDTO;

import java.util.List;

public interface PayrollService {
    List<PayrollDTO> getAllPayrolls();
    PayrollDTO getPayrollById(Long id);
    PayrollDTO processPayroll(PayrollDTO payrollDTO); // Handles payroll calculation
    PayrollDTO updatePayroll(Long id, PayrollDTO payrollDTO);
    void deletePayroll(Long id);
}
