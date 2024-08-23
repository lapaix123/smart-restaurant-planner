package com.restaurant.smart_restaurant_planner.repository;

import com.restaurant.smart_restaurant_planner.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByPhoneNumber(String phoneNumber);
}