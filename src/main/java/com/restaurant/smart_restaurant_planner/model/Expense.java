package com.restaurant.smart_restaurant_planner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String expenseName;

    private double amount;

    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    @ManyToOne
    private Budget budget;
}
