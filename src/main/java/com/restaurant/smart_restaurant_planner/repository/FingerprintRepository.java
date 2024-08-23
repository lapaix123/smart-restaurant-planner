package com.restaurant.smart_restaurant_planner.repository;

import com.restaurant.smart_restaurant_planner.model.Fingerprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FingerprintRepository extends JpaRepository<Fingerprint, Long> {
}