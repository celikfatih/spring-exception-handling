package com.fati.exceptionhandling.repository;

import com.fati.exceptionhandling.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * author @ fati
 * created @ 7.09.2020
 */

public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findById(Long id);
    boolean existsById(Long id);
}
