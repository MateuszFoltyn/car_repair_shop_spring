package com.example.car_repair_shop.web;


import com.example.car_repair_shop.persistance.Car;
import com.example.car_repair_shop.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;


    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(carService.findAll());
    }


    @GetMapping("/{brand}")
    public ResponseEntity<List<Car>> getBrand(@PathVariable String brand) {
        return ResponseEntity.ok(carService.findByBrand(brand));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Car> getId(@PathVariable Long id) {
        return ResponseEntity.ok(carService.findById(id));
    }

    @GetMapping("/{customerId}/customer")
    public ResponseEntity<List<Car>> findByCustomerId(@PathVariable Long customerId ) {
        return ResponseEntity.ok(carService.findByCustomerId(customerId));
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.deleteById(id);
    }

}
