package com.example.car_repair_shop.persistance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String type;
    private String color;

    @Range(max = 2022)
    private Integer productionYear;
    private Integer horsePower;

    @Range(min = 3, max = 5)
    private Integer doorsNumber;
    private Integer fuelConsumption;
    private String fuelType;

    @OneToOne
    private User user;
}
