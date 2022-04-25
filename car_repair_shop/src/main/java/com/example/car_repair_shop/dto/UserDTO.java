package com.example.car_repair_shop.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private List<String> roles;


    public Long getId() {
        return id;
    }

    public List<String> getRoles() {
        return roles;
    }
}
