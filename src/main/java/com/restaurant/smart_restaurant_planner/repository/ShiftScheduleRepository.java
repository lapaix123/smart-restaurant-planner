package com.restaurant.smart_restaurant_planner.repository;

import com.restaurant.smart_restaurant_planner.model.ShiftSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShiftScheduleRepository extends JpaRepository<ShiftSchedule, Long> {
    List<ShiftSchedule> findByEmployeeId(Long employeeId);
}