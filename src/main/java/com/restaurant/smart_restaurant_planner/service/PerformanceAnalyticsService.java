package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.PerformanceAnalyticsDTO;

import java.util.List;

public interface PerformanceAnalyticsService {
    List<PerformanceAnalyticsDTO> getAllPerformanceAnalytics();
    PerformanceAnalyticsDTO getPerformanceAnalyticsById(Long id);
    PerformanceAnalyticsDTO addPerformanceAnalytics(PerformanceAnalyticsDTO performanceAnalyticsDTO);
    PerformanceAnalyticsDTO updatePerformanceAnalytics(Long id, PerformanceAnalyticsDTO performanceAnalyticsDTO);
    void deletePerformanceAnalytics(Long id);
    List<PerformanceAnalyticsDTO> getPerformanceAnalyticsByEmployeeId(Long employeeId);
}