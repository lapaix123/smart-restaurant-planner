package com.restaurant.smart_restaurant_planner.service.impl;

import com.restaurant.smart_restaurant_planner.dto.AttendanceDTO;
import com.restaurant.smart_restaurant_planner.model.Attendance;
import com.restaurant.smart_restaurant_planner.repository.AttendanceRepository;
import com.restaurant.smart_restaurant_planner.service.AttendanceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AttendanceDTO> getAllAttendances() {
        return attendanceRepository.findAll()
                .stream()
                .map(attendance -> modelMapper.map(attendance, AttendanceDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceDTO getAttendanceById(Long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));
        return modelMapper.map(attendance, AttendanceDTO.class);
    }

    @Override
    public AttendanceDTO addAttendance(AttendanceDTO attendanceDTO) {
        Attendance attendance = modelMapper.map(attendanceDTO, Attendance.class);
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return modelMapper.map(savedAttendance, AttendanceDTO.class);
    }

    @Override
    public AttendanceDTO updateAttendance(Long id, AttendanceDTO attendanceDTO) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));
        modelMapper.map(attendanceDTO, attendance);
        Attendance updatedAttendance = attendanceRepository.save(attendance);
        return modelMapper.map(updatedAttendance, AttendanceDTO.class);
    }

    @Override
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    @Override
    public List<AttendanceDTO> getAttendanceByEmployeeId(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId)
                .stream()
                .map(attendance -> modelMapper.map(attendance, AttendanceDTO.class))
                .collect(Collectors.toList());
    }
}
