package com.restaurant.smart_restaurant_planner.service.impl;

import com.restaurant.smart_restaurant_planner.dto.PayrollDTO;
import com.restaurant.smart_restaurant_planner.model.Payroll;
import com.restaurant.smart_restaurant_planner.repository.PayrollRepository;
import com.restaurant.smart_restaurant_planner.service.PayrollService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayrollServiceImpl implements PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PayrollDTO> getAllPayrolls() {
        return payrollRepository.findAll()
                .stream()
                .map(payroll -> modelMapper.map(payroll, PayrollDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PayrollDTO getPayrollById(Long id) {
        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payroll not found"));
        return modelMapper.map(payroll, PayrollDTO.class);
    }

    @Override
    public PayrollDTO processPayroll(PayrollDTO payrollDTO) {
        Payroll payroll = modelMapper.map(payrollDTO, Payroll.class);
        Payroll processedPayroll = payrollRepository.save(payroll);
        return modelMapper.map(processedPayroll, PayrollDTO.class);
    }

    @Override
    public PayrollDTO updatePayroll(Long id, PayrollDTO payrollDTO) {
        Payroll payroll = payrollRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payroll not found"));
        modelMapper.map(payrollDTO, payroll);
        Payroll updatedPayroll = payrollRepository.save(payroll);
        return modelMapper.map(updatedPayroll, PayrollDTO.class);
    }

    @Override
    public void deletePayroll(Long id) {
        payrollRepository.deleteById(id);
    }
}
