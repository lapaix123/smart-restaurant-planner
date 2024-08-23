package com.restaurant.smart_restaurant_planner.controller;

import com.restaurant.smart_restaurant_planner.dto.AttendanceDTO;
import com.restaurant.smart_restaurant_planner.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/check-in")
    public ResponseEntity<AttendanceDTO> checkIn(@RequestBody AttendanceDTO attendanceDTO) {
        AttendanceDTO attendance = attendanceService.addAttendance(attendanceDTO);
        return ResponseEntity.ok(attendance);
    }

    @PutMapping("/check-out/{id}")
    public ResponseEntity<AttendanceDTO> checkOut(@PathVariable Long id, @RequestBody AttendanceDTO attendanceDTO) {
        AttendanceDTO updatedAttendance = attendanceService.updateAttendance(id, attendanceDTO);
        return ResponseEntity.ok(updatedAttendance);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<AttendanceDTO>> getAttendanceByEmployee(@PathVariable Long employeeId) {
        List<AttendanceDTO> attendances = attendanceService.getAttendanceByEmployeeId(employeeId);
        return ResponseEntity.ok(attendances);
    }
}
