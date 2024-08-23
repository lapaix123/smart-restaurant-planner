package com.restaurant.smart_restaurant_planner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fingerprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] fingerprintData; // Store fingerprint data in binary format (Base64 or similar)

    @OneToOne(mappedBy = "fingerprint")
    private User user;
}
