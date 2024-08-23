package com.restaurant.smart_restaurant_planner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Role role;

    private double salary;

    @OneToOne(cascade = CascadeType.ALL)
    private Attendance attendance;
}
