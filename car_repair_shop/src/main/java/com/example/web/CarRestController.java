package com.example.web;


import com.example.service.RestCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<List<RestCar>> getBrand (@PathVariable String brand) {
        return ResponseEntity.ok(restCarService.findByBrand(brand));
    }

    @PostMapping()
    public ResponseEntity<RestCar> save(@RequestBody RestCar restCar) {
        return ResponseEntity.ok(restCarService.save(restCar));
    }

}
