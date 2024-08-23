package com.restaurant.smart_restaurant_planner.service.impl;

import com.restaurant.smart_restaurant_planner.dto.InternshipExpenseDTO;
import com.restaurant.smart_restaurant_planner.model.InternshipExpense;
import com.restaurant.smart_restaurant_planner.repository.InternshipExpenseRepository;
import com.restaurant.smart_restaurant_planner.service.InternshipExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InternshipExpenseServiceImpl implements InternshipExpenseService {

    @Autowired
    private InternshipExpenseRepository internshipExpenseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<InternshipExpenseDTO> getAllInternshipExpenses() {
        return internshipExpenseRepository.findAll()
                .stream()
                .map(internshipExpense -> modelMapper.map(internshipExpense, InternshipExpenseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public InternshipExpenseDTO getInternshipExpenseById(Long id) {
        InternshipExpense internshipExpense = internshipExpenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship Expense not found"));
        return modelMapper.map(internshipExpense, InternshipExpenseDTO.class);
    }

    @Override
    public InternshipExpenseDTO addInternshipExpense(InternshipExpenseDTO internshipExpenseDTO) {
        InternshipExpense internshipExpense = modelMapper.map(internshipExpenseDTO, InternshipExpense.class);
        InternshipExpense savedInternshipExpense = internshipExpenseRepository.save(internshipExpense);
        return modelMapper.map(savedInternshipExpense, InternshipExpenseDTO.class);
    }

    @Override
    public InternshipExpenseDTO updateInternshipExpense(Long id, InternshipExpenseDTO internshipExpenseDTO) {
        InternshipExpense internshipExpense = internshipExpenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internship Expense not found"));
        modelMapper.map(internshipExpenseDTO, internshipExpense);
        InternshipExpense updatedInternshipExpense = internshipExpenseRepository.save(internshipExpense);
        return modelMapper.map(updatedInternshipExpense, InternshipExpenseDTO.class);
    }

    @Override
    public void deleteInternshipExpense(Long id) {
        internshipExpenseRepository.deleteById(id);
    }

    @Override
    public List<InternshipExpenseDTO> getInternshipExpensesByInternId(Long internId) {
        return internshipExpenseRepository.findByInternId(internId)
                .stream()
                .map(internshipExpense -> modelMapper.map(internshipExpense, InternshipExpenseDTO.class))
                .collect(Collectors.toList());
    }
}
