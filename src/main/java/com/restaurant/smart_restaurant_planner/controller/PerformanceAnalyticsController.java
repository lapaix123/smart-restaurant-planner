package com.restaurant.smart_restaurant_planner.controller;

import com.restaurant.smart_restaurant_planner.dto.PerformanceAnalyticsDTO;
import com.restaurant.smart_restaurant_planner.service.PerformanceAnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/performance")
public class PerformanceAnalyticsController {

    @Autowired
    private PerformanceAnalyticsService performanceAnalyticsService;

    @PostMapping("/add")
    public ResponseEntity<PerformanceAnalyticsDTO> addPerformanceAnalytics(@RequestBody PerformanceAnalyticsDTO performanceAnalyticsDTO) {
        PerformanceAnalyticsDTO createdAnalytics = performanceAnalyticsService.addPerformanceAnalytics(performanceAnalyticsDTO);
        return ResponseEntity.ok(createdAnalytics);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<PerformanceAnalyticsDTO>> getPerformanceByEmployee(@PathVariable Long employeeId) {
        List<PerformanceAnalyticsDTO> analytics = performanceAnalyticsService.getPerformanceAnalyticsByEmployeeId(employeeId);
        return ResponseEntity.ok(analytics);
    }
}
