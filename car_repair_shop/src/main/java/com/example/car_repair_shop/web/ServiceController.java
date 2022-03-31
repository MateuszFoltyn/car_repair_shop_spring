package com.example.car_repair_shop.web;


import com.example.car_repair_shop.enumerated.ServiceType;
import com.example.car_repair_shop.persistance.Service;
import com.example.car_repair_shop.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service")
public class ServiceController {

    private final ServiceService serviceService;


    @GetMapping
    ResponseEntity<List<Service>>getAll(){
        return ResponseEntity.ok(serviceService.findAll());
    }

    @GetMapping("/{serviceType}")
    ResponseEntity<List<Service>> getType(@PathVariable ServiceType serviceType) {
        return ResponseEntity.ok(serviceService.findByType(serviceType));
    }

}
