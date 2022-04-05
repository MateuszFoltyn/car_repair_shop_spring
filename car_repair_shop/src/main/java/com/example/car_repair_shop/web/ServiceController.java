package com.example.car_repair_shop.web;


import com.example.car_repair_shop.enumerated.ServiceType;
import com.example.car_repair_shop.persistance.Car;
import com.example.car_repair_shop.persistance.Customer;
import com.example.car_repair_shop.persistance.Service;
import com.example.car_repair_shop.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/services")
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


    @GetMapping("/{id}")
    public ResponseEntity<Service> getId(@PathVariable Long id) {
        return ResponseEntity.ok(serviceService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Service> save(@Valid @RequestBody Service service) {
        return ResponseEntity.ok(serviceService.save(service));
    }

    @PostMapping("/{carId}/service/{serviceId}")
    public ResponseEntity<Service> serviceToDo(@PathVariable Long carId, @PathVariable Long serviceId) {
        return ResponseEntity.ok(serviceService.serviceToDo(carId, serviceId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceService.deleteById(id);
    }

}
