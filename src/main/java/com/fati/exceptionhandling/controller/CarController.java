package com.fati.exceptionhandling.controller;

import com.fati.exceptionhandling.model.Car;
import com.fati.exceptionhandling.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * author @ fati
 * created @ 7.09.2020
 */

@RestController
@RequestMapping(path = "/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping(path = {"{id}"})
    public ResponseEntity<Car> get(@PathVariable Long id) {
        return ResponseEntity.ok().body(carService.get(id));
    }

    @GetMapping(path = {"all"})
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok().body(carService.getAll());
    }

    @DeleteMapping(path = {"{id}"})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Car> save(@Valid @RequestBody Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(car));
    }
}
