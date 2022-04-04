package com.example.car_repair_shop.service;

import com.example.car_repair_shop.persistance.Customer;
import com.example.car_repair_shop.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public List<Customer> findByBrand(String brand) {
        return customerRepository.
    }

    public List<Customer> findBySecondName(String secondName) {
        return customerRepository.findBySecondName(secondName);
    }



}
