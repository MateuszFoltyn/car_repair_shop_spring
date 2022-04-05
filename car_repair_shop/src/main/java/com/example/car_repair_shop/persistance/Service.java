package com.example.car_repair_shop.persistance;


import com.example.car_repair_shop.enumerated.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
//    @NotBlank(message = "Type is required!")
    private ServiceType type;

    @Range(min = 50)
    private Long price;

    private String description;

    @OneToOne
    private Car car;







}
