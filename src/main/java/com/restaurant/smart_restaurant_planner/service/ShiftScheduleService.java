package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.ShiftScheduleDTO;

import java.util.List;

public interface ShiftScheduleService {
    List<ShiftScheduleDTO> getAllShiftSchedules();
    ShiftScheduleDTO getShiftScheduleById(Long id);
    ShiftScheduleDTO addShiftSchedule(ShiftScheduleDTO shiftScheduleDTO);
    ShiftScheduleDTO updateShiftSchedule(Long id, ShiftScheduleDTO shiftScheduleDTO);
    void deleteShiftSchedule(Long id);
    List<ShiftScheduleDTO> getShiftSchedulesByEmployeeId(Long employeeId);
}