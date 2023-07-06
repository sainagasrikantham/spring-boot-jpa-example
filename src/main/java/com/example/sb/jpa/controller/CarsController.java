package com.example.sb.jpa.controller;

import com.example.sb.jpa.exception.ResourceNotFoundException;
import com.example.sb.jpa.model.Car;
import com.example.sb.jpa.repository.CarRepository;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarsController {
    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @GetMapping
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable(value = "id") Long carId)
            throws ResourceNotFoundException {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id :: " + carId));
        return ResponseEntity.ok().body(car);
    }

    @PostMapping
    public Car createCar(@Valid @RequestBody Car car) {
        return carRepository.save(car);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable(value = "id") long carId,
                                                   @Valid @RequestBody Car input) throws ResourceNotFoundException {
        Car current = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for id :: " + carId));

        current.setMake(input.getMake());
        current.setModel(input.getModel());
        final Car updatedEmployee = carRepository.save(current);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCar(@PathVariable(value = "id") Long carId)
            throws ResourceNotFoundException {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + carId));

        carRepository.delete(car);
        return Boolean.TRUE;
    }
}
