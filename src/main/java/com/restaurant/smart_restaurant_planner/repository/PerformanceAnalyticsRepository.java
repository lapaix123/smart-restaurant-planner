package com.restaurant.smart_restaurant_planner.repository;

import com.restaurant.smart_restaurant_planner.model.PerformanceAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PerformanceAnalyticsRepository extends JpaRepository<PerformanceAnalytics, Long> {
    List<PerformanceAnalytics> findByEmployeeId(Long employeeId);
}