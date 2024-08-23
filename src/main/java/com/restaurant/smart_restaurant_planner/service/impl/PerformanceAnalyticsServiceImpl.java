package com.restaurant.smart_restaurant_planner.service.impl;

import com.restaurant.smart_restaurant_planner.dto.PerformanceAnalyticsDTO;
import com.restaurant.smart_restaurant_planner.model.PerformanceAnalytics;
import com.restaurant.smart_restaurant_planner.repository.PerformanceAnalyticsRepository;
import com.restaurant.smart_restaurant_planner.service.PerformanceAnalyticsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerformanceAnalyticsServiceImpl implements PerformanceAnalyticsService {

    @Autowired
    private PerformanceAnalyticsRepository performanceAnalyticsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PerformanceAnalyticsDTO> getAllPerformanceAnalytics() {
        return performanceAnalyticsRepository.findAll()
                .stream()
                .map(performanceAnalytics -> modelMapper.map(performanceAnalytics, PerformanceAnalyticsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PerformanceAnalyticsDTO getPerformanceAnalyticsById(Long id) {
        PerformanceAnalytics performanceAnalytics = performanceAnalyticsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Performance Analytics not found"));
        return modelMapper.map(performanceAnalytics, PerformanceAnalyticsDTO.class);
    }

    @Override
    public PerformanceAnalyticsDTO addPerformanceAnalytics(PerformanceAnalyticsDTO performanceAnalyticsDTO) {
        PerformanceAnalytics performanceAnalytics = modelMapper.map(performanceAnalyticsDTO, PerformanceAnalytics.class);
        PerformanceAnalytics savedPerformanceAnalytics = performanceAnalyticsRepository.save(performanceAnalytics);
        return modelMapper.map(savedPerformanceAnalytics, PerformanceAnalyticsDTO.class);
    }

    @Override
    public PerformanceAnalyticsDTO updatePerformanceAnalytics(Long id, PerformanceAnalyticsDTO performanceAnalyticsDTO) {
        PerformanceAnalytics performanceAnalytics = performanceAnalyticsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Performance Analytics not found"));
        modelMapper.map(performanceAnalyticsDTO, performanceAnalytics);
        PerformanceAnalytics updatedPerformanceAnalytics = performanceAnalyticsRepository.save(performanceAnalytics);
        return modelMapper.map(updatedPerformanceAnalytics, PerformanceAnalyticsDTO.class);
    }

    @Override
    public void deletePerformanceAnalytics(Long id) {
        performanceAnalyticsRepository.deleteById(id);
    }

    @Override
    public List<PerformanceAnalyticsDTO> getPerformanceAnalyticsByEmployeeId(Long employeeId) {
        return performanceAnalyticsRepository.findByEmployeeId(employeeId)
                .stream()
                .map(performanceAnalytics -> modelMapper.map(performanceAnalytics, PerformanceAnalyticsDTO.class))
                .collect(Collectors.toList());
    }
}
