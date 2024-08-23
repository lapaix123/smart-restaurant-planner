package com.restaurant.smart_restaurant_planner.service;

import com.restaurant.smart_restaurant_planner.dto.AttendanceDTO;

import java.util.List;

public interface AttendanceService {
    List<AttendanceDTO> getAllAttendances();
    AttendanceDTO getAttendanceById(Long id);
    AttendanceDTO addAttendance(AttendanceDTO attendanceDTO);
    AttendanceDTO updateAttendance(Long id, AttendanceDTO attendanceDTO);
    void deleteAttendance(Long id);
    List<AttendanceDTO> getAttendanceByEmployeeId(Long employeeId);
}