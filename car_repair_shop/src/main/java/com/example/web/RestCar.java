package com.example.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String type;
    private String color;
    private Integer productionYear;
    private Integer horsePower;
    private Integer doorsNumber;
    private Integer fuelConsumption;
    private String fuelType;

}
