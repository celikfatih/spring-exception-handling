package com.fati.exceptionhandling.service;

import com.fati.exceptionhandling.exception.CarNotFoundException;
import com.fati.exceptionhandling.model.Car;
import com.fati.exceptionhandling.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * author @ fati
 * created @ 7.09.2020
 */

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car get(Long id) {
        return carRepository.findById(id).orElseThrow(CarNotFoundException::new);
    }

    public List<Car> getAll() {
        return carRepository.findAll(Sort.by("id").ascending());
    }

    public void remove(Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
        } else {
            throw new CarNotFoundException();
        }
    }

    public Car save(@Valid Car car) {
        return carRepository.save(car);
    }
}
