package com.restaurant.smart_restaurant_planner.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternshipExpense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Employee intern;

    private double expenseAmount;

    private String expenseCoveredBy; // Example: "Rwanda Development Board (RDB)"

    private boolean isApproved;
}
