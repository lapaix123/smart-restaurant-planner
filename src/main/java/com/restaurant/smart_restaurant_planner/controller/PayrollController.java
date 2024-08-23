package com.restaurant.smart_restaurant_planner.controller;

import com.restaurant.smart_restaurant_planner.dto.PayrollDTO;
import com.restaurant.smart_restaurant_planner.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping("/process")
    public ResponseEntity<PayrollDTO> processPayroll(@RequestBody PayrollDTO payrollDTO) {
        PayrollDTO processedPayroll = payrollService.processPayroll(payrollDTO);
        return ResponseEntity.ok(processedPayroll);
    }

    @GetMapping
    public ResponseEntity<List<PayrollDTO>> getAllPayrolls() {
        List<PayrollDTO> payrolls = payrollService.getAllPayrolls();
        return ResponseEntity.ok(payrolls);
    }
}
