package com.restaurant.smart_restaurant_planner.controller;

import com.restaurant.smart_restaurant_planner.dto.ShiftScheduleDTO;
import com.restaurant.smart_restaurant_planner.service.ShiftScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftScheduleController {

    @Autowired
    private ShiftScheduleService shiftScheduleService;

    @PostMapping("/create")
    public ResponseEntity<ShiftScheduleDTO> createShiftSchedule(@RequestBody ShiftScheduleDTO shiftScheduleDTO) {
        ShiftScheduleDTO createdShift = shiftScheduleService.addShiftSchedule(shiftScheduleDTO);
        return ResponseEntity.ok(createdShift);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<ShiftScheduleDTO>> getShiftSchedulesByEmployee(@PathVariable Long employeeId) {
        List<ShiftScheduleDTO> shifts = shiftScheduleService.getShiftSchedulesByEmployeeId(employeeId);
        return ResponseEntity.ok(shifts);
    }
}
