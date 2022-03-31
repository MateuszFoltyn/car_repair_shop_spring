package com.example.car_repair_shop.web;


import com.example.car_repair_shop.service.RestCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarRestController {

    private final RestCarService restCarService;


    @GetMapping
    public ResponseEntity<List<RestCar>> getAll() {
        return ResponseEntity.ok(restCarService.findAll());
    }


    @GetMapping("car/{brand}")
    public ResponseEntity<List<RestCar>> getBrand(@PathVariable String brand) {
        return ResponseEntity.ok(restCarService.findByBrand(brand));
    }

    @PostMapping
    public ResponseEntity<RestCar> save(@RequestBody RestCar restCar) {
        return ResponseEntity.ok(restCarService.save(restCar));
    }

    @DeleteMapping
    public void delete(@RequestBody Long id) {
        restCarService.deleteById(id);
    }

}
