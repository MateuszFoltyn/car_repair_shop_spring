package com.example.car_repair_shop.web;

import com.example.car_repair_shop.persistance.Customer;
import com.example.car_repair_shop.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{secondName}")
    public ResponseEntity<List<Customer>> getSecondName(@PathVariable String secondName) {
        return ResponseEntity.ok(customerService.findBySecondName(secondName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getId(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

}
