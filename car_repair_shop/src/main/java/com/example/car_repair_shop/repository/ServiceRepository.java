package com.example.car_repair_shop.repository;

import com.example.car_repair_shop.persistance.Service;
import com.example.car_repair_shop.enumerated.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByType(ServiceType serviceType);

}
