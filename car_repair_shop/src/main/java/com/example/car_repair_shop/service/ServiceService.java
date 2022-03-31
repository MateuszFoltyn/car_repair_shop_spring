package com.example.car_repair_shop.service;

import com.example.car_repair_shop.persistance.Service;
import com.example.car_repair_shop.repository.ServiceRepository;
import com.example.car_repair_shop.enumerated.ServiceType;
import lombok.RequiredArgsConstructor;



import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public List<Service> findByType(ServiceType serviceType) {
        return serviceRepository.findByType(serviceType);
    }

    public Service findById(Long id) {
        return serviceRepository.findById(id).orElseThrow();
    }

    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    public Service save(Service service) {
        return serviceRepository.save(service);
    }

    public void deleteById(Long id) {
        serviceRepository.deleteById(id);
    }



}
