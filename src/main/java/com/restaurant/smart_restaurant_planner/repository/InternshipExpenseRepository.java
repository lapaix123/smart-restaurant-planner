package com.restaurant.smart_restaurant_planner.repository;

import com.restaurant.smart_restaurant_planner.model.InternshipExpense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternshipExpenseRepository extends JpaRepository<InternshipExpense, Long> {
    List<InternshipExpense> findByInternId(Long internId);
}