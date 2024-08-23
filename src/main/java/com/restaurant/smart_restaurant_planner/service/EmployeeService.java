package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.EmployeeDTO;
import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
}