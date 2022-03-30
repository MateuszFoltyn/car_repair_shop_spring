package com.example.web;


import com.example.service.RestCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")   //TODO UZUPELNIC NAWIAS PATH'EM !!!!!!!!
public class CarRestController {

    private final RestCarService restCarService;


    @GetMapping
    public ResponseEntity<List<RestCar>> getAll() {
        return ResponseEntity.ok(restCarService.findAll());
    }


    @GetMapping("car/{make}")
    public ResponseEntity<List<RestCar>> getMake (@PathVariable String brand) {
        List<RestCar> carsList = restCarService.findAll().stream()
                .filter(t -> t.getBrand().equals(brand))
                .collect(Collectors.toList());
        return ResponseEntity.ok(carsList);
    }

}
