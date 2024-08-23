package com.restaurant.smart_restaurant_planner.service.impl;

import com.restaurant.smart_restaurant_planner.dto.ShiftScheduleDTO;
import com.restaurant.smart_restaurant_planner.model.ShiftSchedule;
import com.restaurant.smart_restaurant_planner.repository.ShiftScheduleRepository;
import com.restaurant.smart_restaurant_planner.service.ShiftScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShiftScheduleServiceImpl implements ShiftScheduleService {

    @Autowired
    private ShiftScheduleRepository shiftScheduleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ShiftScheduleDTO> getAllShiftSchedules() {
        return shiftScheduleRepository.findAll()
                .stream()
                .map(shiftSchedule -> modelMapper.map(shiftSchedule, ShiftScheduleDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ShiftScheduleDTO getShiftScheduleById(Long id) {
        ShiftSchedule shiftSchedule = shiftScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shift Schedule not found"));
        return modelMapper.map(shiftSchedule, ShiftScheduleDTO.class);
    }

    @Override
    public ShiftScheduleDTO addShiftSchedule(ShiftScheduleDTO shiftScheduleDTO) {
        ShiftSchedule shiftSchedule = modelMapper.map(shiftScheduleDTO, ShiftSchedule.class);
        ShiftSchedule savedShiftSchedule = shiftScheduleRepository.save(shiftSchedule);
        return modelMapper.map(savedShiftSchedule, ShiftScheduleDTO.class);
    }

    @Override
    public ShiftScheduleDTO updateShiftSchedule(Long id, ShiftScheduleDTO shiftScheduleDTO) {
        ShiftSchedule shiftSchedule = shiftScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shift Schedule not found"));
        modelMapper.map(shiftScheduleDTO, shiftSchedule);
        ShiftSchedule updatedShiftSchedule = shiftScheduleRepository.save(shiftSchedule);
        return modelMapper.map(updatedShiftSchedule, ShiftScheduleDTO.class);
    }

    @Override
    public void deleteShiftSchedule(Long id) {
        shiftScheduleRepository.deleteById(id);
    }

    @Override
    public List<ShiftScheduleDTO> getShiftSchedulesByEmployeeId(Long employeeId) {
        return shiftScheduleRepository.findByEmployeeId(employeeId)
                .stream()
                .map(shiftSchedule -> modelMapper.map(shiftSchedule, ShiftScheduleDTO.class))
                .collect(Collectors.toList());
    }
}
