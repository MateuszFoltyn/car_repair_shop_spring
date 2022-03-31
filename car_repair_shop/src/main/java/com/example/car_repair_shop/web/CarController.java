package com.example.car_repair_shop.web;


import com.example.car_repair_shop.persistance.Car;
import com.example.car_repair_shop.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
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

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.deleteById(id);
    }

}
